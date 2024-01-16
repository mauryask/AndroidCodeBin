package com.googel.camera2api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
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

        LinearLayout row = new LinearLayout(this);
        row.setBackgroundColor(Color.parseColor("#909090"));

        TextView txtView1 = new TextView(this);
        TextView txtView2 = new TextView(this);
        TextView txtView3 = new TextView(this);


        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) txtView1.getLayoutParams();
        txtView1.setText("1");
        txtView1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        txtView1.setGravity(Gravity.CENTER);
        params1.weight = 1;
        txtView1.setLayoutParams(params1);

        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) txtView2.getLayoutParams();
        txtView2.setText("image1.jpg");
        txtView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        txtView2.setGravity(Gravity.CENTER);
        params2.weight = 3;
        txtView2.setLayoutParams(params2);

        LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) txtView3.getLayoutParams();
        txtView3.setText("3021.356 KB");
        txtView3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        txtView3.setGravity(Gravity.CENTER);
        params3.weight = 1;
        txtView3.setLayoutParams(params3);

        row.addView(txtView1);
        row.addView(txtView2);
        row.addView(txtView3);

        binding.tableLayout.addView(row);
    }
}