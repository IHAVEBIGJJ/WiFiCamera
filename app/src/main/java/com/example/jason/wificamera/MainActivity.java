package com.example.jason.wificamera;


import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Environment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import chird.StreamView;
import chird.chd_wmp_apis;
import chird.st_VideoFrame;
import chird.st_VideoParamInfo;


public class MainActivity extends AppCompatActivity {
    private chd_wmp_apis chd_wmp = new chd_wmp_apis();
    private st_VideoParamInfo info = new st_VideoParamInfo();
    private st_VideoFrame VF = new st_VideoFrame();

    public boolean m_FullScreenFlag = true;
    private StreamView m_StreamView;
    private Button disconnect;
    private Button takephoto;
    private Button getback;


    private Bitmap m_Bitmap  = null; // yuv显示给jni赋值操作

    private chd_demo_sdcard sdcard = new chd_demo_sdcard();
    private boolean m_ConnectFlag = false;

    private boolean m_VideoRunFlag = false;



    private String getFileSavePath()
    {
        StringBuilder log = new StringBuilder();
        String inPath = Environment.getExternalStorageDirectory().getPath();
        File dir = new File(inPath + "/wificamera/");
        if(!dir.exists()) dir.mkdir();
        return inPath + "/wificamera/";
    }

    private String getTimeString()
    {
        SimpleDateFormat dateFormat24 = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss:SS");
        String time = dateFormat24.format(Calendar.getInstance().getTime());
        time = time.replace("","_");
        return time.replace("","_");
    }



    private long m_handle = 0;
    byte[] buffer = new byte[5*1024*1024];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        m_StreamView = (StreamView) findViewById(R.id.streamView);
        disconnect = (Button) findViewById(R.id.button2);
        takephoto = (Button) findViewById(R.id.button4);
        getback = (Button) findViewById(R.id.button3);
        Log.v("step1", "第一步成功");



        m_handle = chd_wmp.CHD_WMP_ConnectDevice("192.168.100.254");
        if (m_handle < 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "警告：連接失敗", Toast.LENGTH_SHORT);
            toast.show();
        } else if (m_handle > 0) {
            Toast toast2 = Toast.makeText(getApplicationContext(), "連接成功", Toast.LENGTH_SHORT);
            toast2.show();
        }
        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chd_wmp.CHD_WMP_Video_End(m_handle);

                Toast toast = Toast.makeText(getApplicationContext(), "以斷開連接", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        getback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                File myfile = new File("/sdcard/UserPhoto/Picture");
                myfile.mkdirs();
                Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                String fname = "Image-"+ n +".jpg";
                File file = new File (myfile, fname);
                if (file.exists ()) file.delete ();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    m_Bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                    out.flush();
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(m_handle > 1)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "以取得照片", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(m_handle < 1)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "無法拍攝照片", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Log.v("step2", "第二步成功");
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        Log.v("fail!","失敗!"+ width + ", "+height);
        m_StreamView.SetActivity(width, height);
        m_Bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);

        //取得螢幕的分辨率大小
        DisplayMetrics dm=new DisplayMetrics();//创建矩阵
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int w = dm.widthPixels; //得到屏幕的宽度
        int h = dm.heightPixels; //得到屏幕的高度
//        scaleWidth=((float)w)/width;
//        scaleHeight=((float)h)/height;


        int result = chd_wmp.CHD_WMP_Video_SetResolu(m_handle,640,480);
        if(result <0)
        {
            Toast toast=Toast.makeText(getApplicationContext(), "長寬沒有被改變", Toast.LENGTH_SHORT);
            toast.show();
            Log.v("fail!","失敗!"+result);
        }else if (result >= 0)
        {
            Toast toast=Toast.makeText(getApplicationContext(), "長寬改變成功", Toast.LENGTH_SHORT);
            toast.show();
            Log.v("good","變換成功");
        }

        int ret = chd_wmp.CHD_WMP_Video_Begin(m_handle);
        if (ret < 0)
        {
            Toast toast=Toast.makeText(getApplicationContext(), "警告：無法開啟影像", Toast.LENGTH_SHORT);
            toast.show();
        }

        m_VideoRunFlag = true;

        chd_demo_poll_thread Thread = new chd_demo_poll_thread();

        Thread.start();
        Log.v("step4","第四步成功");

    }

    class chd_demo_poll_thread extends Thread
    {

        int ret = 0, width = 0, height = 0;
        byte [] buffer = new byte[5*1024*1024];

        @Override public void run()
        {

            final st_VideoFrame vframe = new st_VideoFrame();
            int i;

            Log.v("step5","第五步成功 m= " + m_VideoRunFlag);

            while (m_VideoRunFlag)
            {
                ret = chd_wmp.CHD_WMP_Poll(m_handle, 2, 0);//數據監聽函數，同步模式，即時監聽影像、圖片、串流、音頻數據的到來。
                if (ret < 0) continue;
                Log.v("test", "poll ret:"+ret );

                if (ret == chd_wmp.CHD_POLL_TYPE_VIDEO)
                {
                    chd_wmp.CHD_WMP_Video_RequestVideoData(m_handle,vframe, buffer);//獲取一禎影像數據
                    if (vframe.width != width || vframe.height != height)
                    {
                        Log.v("檢測長寬","寬:"+vframe.width +","+"高"+vframe.height);
                        try
                        {
                            m_Bitmap = Bitmap.createBitmap(vframe.width, vframe.height, Bitmap.Config.ARGB_8888);

                        }
                        catch(OutOfMemoryError e)
                        {
                            Toast toast=Toast.makeText(getApplicationContext(), "暫存異常。", Toast.LENGTH_SHORT);
                            toast.show();
                            continue;
                        }
                        width   = vframe.width;
                        height   = vframe.height;
                    }

                    if (vframe.format == vframe.CHD_FMT_MJPEG)
                        ret= chd_wmp.CHD_WMP_Decode_MjpegToBitmap(m_handle,vframe.width,vframe.height,vframe.datalen,m_Bitmap,buffer);
                    else if(vframe.format==vframe.CHD_FMT_YUYV)
                        ret=chd_wmp.CHD_WMP_Decode_YuyvToBitmap(m_handle,vframe.width, vframe.height,m_Bitmap,buffer);


                    else ret= -1;

                    if (ret == 0) {
                        Bitmap Bitmap_scale = Bitmap.createScaledBitmap(m_Bitmap,1280,640,true);
                        m_StreamView.ShowBitmapFrame(Bitmap_scale);

                    }
                }
                else{
                    if(ret >= 0)
                    {
                        if(ret == 1)
                        {
                            chd_wmp.CHD_WMP_Video_RequestPicData(m_handle,vframe,buffer);

                            if(vframe.width != width || vframe.height != height){}
                            for(;;)
                            {
                                try
                                {
                                    m_Bitmap = Bitmap.createBitmap(vframe.width, vframe.height, Bitmap.Config.ARGB_8888);

                                    m_Bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(buffer));
                                    this.ret = 0;
                                    i = this.ret;
                                    if (i != 0) {
                                        break;
                                    }
                                    String str = sdcard.chd_get_sdcard_path() + sdcard.chd_demo_sdcard_gettime() + ".jpg";
                                    Log.v("test1", "filename:" + str);
                                    ret = sdcard.chd_save_bitmap_to_sdcard(str,m_Bitmap);
                                    MainActivity.this.runOnUiThread(new Runnable()
                                    {
                                        public void run()
                                        {
                                            if (chd_demo_poll_thread.this.ret != 0)
                                            {
                                                Toast toast=Toast.makeText(getApplicationContext(), "暫存異常", Toast.LENGTH_SHORT);
                                                toast.show();
                                            }
                                        }
                                    });
                                }catch (OutOfMemoryError localOutOfMemoryError)
                                {
                                    Toast toast=Toast.makeText(getApplicationContext(), "暫存不足", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

