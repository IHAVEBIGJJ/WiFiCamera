package com.example.jason.wificamera;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class chd_demo_sdcard
{
    private static final String TAG = "chd_demo_sdcard";
    public static final int FLAG_SUCCESS = 1;//创建成功
    public static final int FLAG_EXISTS = 2;//已存在
    public static final int FLAG_FAILED = 3;//创建失败


    public static int chd_demo_sdcard_creat_file(String chd_get_sdcard_path)
    {
        File dir = new File(chd_get_sdcard_path);
        if (dir.exists())
        {
            Log.w(TAG,"The directory [ " + chd_get_sdcard_path + " ] has already exists");
            return FLAG_EXISTS;
        }
        if(dir.mkdirs())
        {
            Log.d(TAG,"create directory [ "+ chd_get_sdcard_path + " ] success");
            return FLAG_SUCCESS;
        }
        Log.e(TAG,"create directory [ "+ chd_get_sdcard_path + " ] failed");
        return FLAG_FAILED;
    }

    public String chd_demo_sdcard_gettime()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()).replace(" ", "_").replace(":", "-");
    }

    public String chd_get_sdcard_path()
    {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/chird/";
    }

    /* Error */
    public int chd_save_bitmap_to_sdcard(String paramString, android.graphics.Bitmap paramBitmap)
    {
        // Byte code:
        //   0: new 19	java/io/File
        //   3: dup
        //   4: aload_1
        //   5: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
        //   8: astore_3
        //   9: ldc 104
        //   11: new 75	java/lang/StringBuilder
        //   14: dup
        //   15: ldc 106
        //   17: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   20: aload_1
        //   21: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   24: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   27: invokestatic 112	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   30: pop
        //   31: aload_3
        //   32: invokevirtual 115	java/io/File:createNewFile	()Z
        //   35: pop
        //   36: aconst_null
        //   37: astore_1
        //   38: new 117	java/io/FileOutputStream
        //   41: dup
        //   42: aload_3
        //   43: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   46: astore_3
        //   47: aload_3
        //   48: astore_1
        //   49: aload_2
        //   50: getstatic 126	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   53: bipush 100
        //   55: aload_1
        //   56: invokevirtual 132	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   59: pop
        //   60: aload_1
        //   61: invokevirtual 135	java/io/FileOutputStream:flush	()V
        //   64: aload_1
        //   65: invokevirtual 138	java/io/FileOutputStream:close	()V
        //   68: iconst_0
        //   69: ireturn
        //   70: astore_1
        //   71: iconst_m1
        //   72: ireturn
        //   73: astore_3
        //   74: aload_3
        //   75: invokevirtual 141	java/io/FileNotFoundException:printStackTrace	()V
        //   78: goto -29 -> 49
        //   81: astore_2
        //   82: aload_2
        //   83: invokevirtual 142	java/io/IOException:printStackTrace	()V
        //   86: goto -22 -> 64
        //   89: astore_1
        //   90: aload_1
        //   91: invokevirtual 142	java/io/IOException:printStackTrace	()V
        //   94: goto -26 -> 68
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	97	0	this	chd_demo_sdcard
        //   0	97	1	paramString	String
        //   0	97	2	paramBitmap	android.graphics.Bitmap
        //   8	40	3	localObject	Object
        //   73	2	3	localFileNotFoundException	java.io.FileNotFoundException
        // Exception table:
        //   from	to	target	type
        //   31	36	70	java/io/IOException
        //   38	47	73	java/io/FileNotFoundException
        //   60	64	81	java/io/IOException
        //   64	68	89	java/io/IOException
        return 0;
    }
}