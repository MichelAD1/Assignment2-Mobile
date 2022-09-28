package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FetchNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_news);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        ImageView brew=(ImageView) findViewById(R.id.brnew);
        brew.setX(1000);
        brew.animate().translationX(-450).setDuration(2000);
    }
}