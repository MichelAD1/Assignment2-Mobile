package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

    }

    public void addToDb(View v){
        EditText news_name= (EditText) findViewById(R.id.news_name);
        EditText author= (EditText) findViewById(R.id.author);
        EditText published_at= (EditText) findViewById(R.id.published_at);
        EditText location= (EditText) findViewById(R.id.location);
        EditText description= (EditText) findViewById(R.id.description);
        String news_name_val=news_name.getText().toString();
        String author_val=author.getText().toString();
        String published_at_val=published_at.getText().toString();
        String location_val=location.getText().toString();
        String description_val=description.getText().toString();
        SQLiteDatabase sql = this.openOrCreateDatabase("newsdb", MODE_PRIVATE, null);
        sql.execSQL("CREATE Table IF NOT EXISTS news (news_name VARCHAR, author VARCHAR, published_at TEXT, location VARCHAR, description TEXT)");
        sql.execSQL("INSERT INTO news(news_name, author,published_at,location,description) VALUES (news_name_val,author_val,published_at_val,location_val,description_val)");
        Intent i= new Intent(getApplicationContext(),FetchNews.class);
        startActivity(i);

    }
}