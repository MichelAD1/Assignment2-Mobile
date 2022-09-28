package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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


        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("newsdb", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS news (news_name VARCHAR, author VARCHAR, published_at DATE, location VARCHAR, description TEXT)");
//            sql.execSQL("INSERT INTO news(news_name, author) VALUES ('Death of her', 'Doe')");

//            sql.execSQL("DELETE FROM news where author = 'Doe'");


            Cursor c = sql.rawQuery("Select * from news", null);
            int n_nameIndex = c.getColumnIndex("news_name");
            c.moveToFirst();

            while(c!= null){
                String news_name = c.getString(n_nameIndex) + " ";
                Toast.makeText(getApplicationContext(), news_name, Toast.LENGTH_LONG).show();
                c.moveToNext();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}