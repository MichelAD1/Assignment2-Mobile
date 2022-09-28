package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsDetails extends AppCompatActivity {
    ListView my_list_2;
    ArrayList<String> the_list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        my_list_2= findViewById(R.id.my_list_2);
        the_list=new ArrayList<String>();

        Intent intent=getIntent();
        String news_name_i=intent.getStringExtra("news_name");

        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("newsdb", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS news (news_name VARCHAR, author VARCHAR, published_at TEXT, location VARCHAR, description TEXT)");
            Cursor c = sql.rawQuery("Select * from news where TRIM(news_name) = '"+news_name_i.trim()+"'", null);

            int n_nameIndex = c.getColumnIndex("news_name");
            int authorIndex= c.getColumnIndex("author");
            int publishedIndex= c.getColumnIndex("published_at");
            int locationIndex= c.getColumnIndex("location");
            int descIndex=c.getColumnIndex("description");
            c.moveToFirst();

            while(c!= null){
                String news_name_n = "News: "+c.getString(n_nameIndex) + " ";
                String author_n = "Author: "+c.getString(authorIndex) + " ";
                String published_n = "Published on: "+c.getString(publishedIndex) + " ";
                String location_n = "Location: "+c.getString(locationIndex) + " ";
                String desc_n = "Description: "+c.getString(descIndex) + " ";
                the_list.add(news_name_n);
                the_list.add(author_n);
                the_list.add(published_n);
                the_list.add(location_n);
                the_list.add(desc_n);
                c.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.text_color_layout,the_list);
        my_list_2.setAdapter(adapter);
    }
}