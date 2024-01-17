package com.googel.camera2api;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<TableData> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        addData();
        RecyclerView tableRecyclerView = findViewById(R.id.tableRecyclerView);
        tableRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        TableAdapter adapter = new TableAdapter(mList);
        tableRecyclerView.setAdapter(adapter);
    }

    /**
     * TODO: Also implement total file size limitation
     * TODO: Convert the file size to MB and KB accordingly
     * TODO: implement if selected file size is greater than 6 MB do not select it
     * */

    /*
    * import java.io.File;

public class FileSizeUtil
* {
    public static String getFileSize(File file) {
        long fileSizeInBytes = file.length();
        double fileSizeInKB = fileSizeInBytes / 1024.0;
        double fileSizeInMB = fileSizeInKB / 1024.0;

        String formattedFileSize;
        if (fileSizeInMB >= 1) {
            formattedFileSize = String.format("%.1f MB", fileSizeInMB);
        } else {
            formattedFileSize = String.format("%.1f KB", fileSizeInKB);
        }

        return formattedFileSize;
    }
}
    * */

    private void addData()
    {
        TableData tableData = new TableData();
        tableData.setSerialNo("No");
        tableData.setFileName("File Name");
        tableData.setFileSize("Capacity");
        mList.add(tableData);

        for(int i=1; i<=5; i++)
        {
            tableData = new TableData();
            tableData.setSerialNo(i+"");
            String fileName = "65185_165156.jpg";

            if(fileName.length() > 13)
            {
                String s1 = fileName.substring(0,5);
                String s2 = fileName.substring(fileName.length()-6);
                fileName = s1 + ".." + s2;
            }

            tableData.setFileName(fileName);
            tableData.setFileSize("1.23MB");
            mList.add(tableData);
        }
    }
}

/*
*
* */