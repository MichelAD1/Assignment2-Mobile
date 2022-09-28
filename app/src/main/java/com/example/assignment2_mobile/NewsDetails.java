package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Intent intent=getIntent();
        String news_name=intent.getStringExtra("news_name");
        TextView newsR=findViewById(R.id.newsR);
        newsR.setText("News: "+news_name);
    }
}