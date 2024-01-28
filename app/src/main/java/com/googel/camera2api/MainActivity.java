package com.googel.camera2api;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<TableData> mList = new ArrayList<>();
        populateList(mList);
        TableAdapter tableAdapter = new TableAdapter(this, mList);
        recyclerView.setAdapter(tableAdapter);
    }

    private void populateList(List<TableData> mList)
    {
       String[]  fileName = {"usbvasbdfahsbd.png", "isndgndfb_uigdsf63765.jpeg",
               "uiasbdf6834.gif", "651565815765_6155.jpg", "uyasdb_7345364.png"};
       String[] fileSize = {"125.02KB", "684.KB", "5.36MB", "7.23MB", "10.23MB"};

       for(int i=0; i<5; i++)
       {
           TableData data = new TableData();
           data.setItemIndex(i+1);
           data.setFileName(fileName[i]);
           data.setFileSize(fileSize[i]);
           mList.add(data);
       }
    }
}

