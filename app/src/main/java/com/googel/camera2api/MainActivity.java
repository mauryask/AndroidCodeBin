package com.googel.camera2api;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner materialSpinner1, materialSpinner2, materialSpinner3;
    List<SpinnerData> mList;
    Set<SpinnerData> selectedItems;
    SpinnerAdapter adapter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();

        materialSpinner1 = findViewById(R.id.spinner_materials1);
        materialSpinner2 = findViewById(R.id.spinner_materials2);
        materialSpinner3 = findViewById(R.id.spinner_materials3);

        materialSpinner1.setOnItemSelectedListener(this);
        materialSpinner2.setOnItemSelectedListener(this);
        materialSpinner3.setOnItemSelectedListener(this);

        adapter = new SpinnerAdapter(this, mList);

        materialSpinner1.setAdapter(adapter);
        materialSpinner2.setAdapter(adapter);
        materialSpinner3.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        int spinnerId = adapterView.getId();

        if(spinnerId == R.id.spinner_materials1 && materialSpinner1.getSelectedItemPosition() != 0)
        {
            SpinnerData data = (SpinnerData) adapterView.getItemAtPosition(i);
            if(!selectedItems.contains(data))
                selectedItems.add(data);
            //else show popup: already selected
            Toast.makeText(MainActivity.this, ""+data.material, Toast.LENGTH_SHORT).show();
        }
        else if(spinnerId == R.id.spinner_materials2 && materialSpinner2.getSelectedItemPosition() != 0)
        {
            SpinnerData data = (SpinnerData) adapterView.getItemAtPosition(i);
            if(!selectedItems.contains(data))
                selectedItems.add(data);
            //else show popup: already selected
            Toast.makeText(MainActivity.this, ""+data.material, Toast.LENGTH_SHORT).show();
        }
        else if(spinnerId == R.id.spinner_materials3 && materialSpinner3.getSelectedItemPosition() != 0)
        {
            SpinnerData data = (SpinnerData) adapterView.getItemAtPosition(i);
            if(!selectedItems.contains(data))
                selectedItems.add(data);
            //else show popup: already selected
            Toast.makeText(MainActivity.this, ""+data.material, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    void initList()
    {
        mList = new ArrayList<>();
        selectedItems = new HashSet<>();
        mList.add(new SpinnerData("Choose Materials..."));
        mList.add(new SpinnerData("Display"));
        mList.add(new SpinnerData("Speaker"));
        mList.add(new SpinnerData("Processor"));
        mList.add(new SpinnerData("Cable"));
        mList.add(new SpinnerData("RAM"));
    }
}

