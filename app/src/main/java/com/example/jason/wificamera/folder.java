package com.example.jason.wificamera;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class folder extends Activity{

    public String m_RootPath = new String();
    public String[] m_SnapFilename;
    public int m_SnapNum;
    private Button m_SnapImageButton;
    private List<String> m_VideoList = new ArrayList();
    private ListView m_VideoListView;
    private LinearLayout m_fileLayout;
    private TextView m_filepath;
    public int m_menu = 0;
    public String[] m_video;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(128, 128);

        this.m_RootPath = getIntent().getStringExtra("filepath");
        folder_get_viewid();
        folder_get_snap_file(this.m_RootPath + "snap/");
    }
    public void folder_button_click_listern()
    {
        m_SnapImageButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                folder.this.m_menu = 1;

            }
        });
    }

    private void folder_get_snap_file(String paramString) {
        File[] arrayOfFile = new File(paramString).listFiles();
        this.m_SnapNum = arrayOfFile.length;
        this.m_SnapFilename = new String[arrayOfFile.length];
        int j = 0;
        int i = 0;
        while (j < this.m_SnapNum) {
            Object localObject = arrayOfFile[j];
            localObject = ((File) localObject).getPath().substring(paramString.length(), ((File) localObject).getPath().length());
            this.m_SnapFilename[i] = (String) localObject;
            j += 1;
            i += 1;
        }
    }
    public void folder_get_viewid()
    {
        //m_SnapImageButton = (Button)findViewById(R.id.button);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

}
