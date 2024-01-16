package com.googel.camera2api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableRow;
import android.widget.TextView;

import com.googel.camera2api.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        TableRow row = new TableRow(this);
        row.setBackgroundColor(Color.parseColor("#909090"));
        TextView txtView1 = new TextView(this);
        TextView txtView2 = new TextView(this);
        TextView txtView3 = new TextView(this);

        txtView1.setText("1");
        //txtView1.setTextAppearance(R.style.StyleLeftTextView);

        txtView2.setText("image1.jpg");
       // txtView2.setTextAppearance(R.style.StyleCenterTextView);

        txtView3.setText("3021.356 KB");
        //txtView3.setTextAppearance(R.style.StyleRightTextView);
        TextViewCompat.setTextAppearance(txtView1, R.style.StyleLeftTextView);
        row.addView(txtView1);
        row.addView(txtView2);
        row.addView(txtView3);

        binding.tableLayout.addView(row);
    }
}