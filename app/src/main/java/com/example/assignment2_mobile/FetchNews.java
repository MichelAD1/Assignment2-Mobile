package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FetchNews extends AppCompatActivity {

    ListView my_list;
    ArrayList<String> the_list;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_news);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        ImageView brew=(ImageView) findViewById(R.id.brnew);
        brew.setX(1000);
        brew.animate().translationX(-450).setDuration(2000);

        my_list= findViewById(R.id.my_list);
        the_list=new ArrayList<String>();

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
                the_list.add(news_name);
                c.moveToNext();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,the_list);
        my_list.setAdapter(adapter);
        my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getApplicationContext(),NewsDetails.class);
                intent.putExtra("news_name",the_list.get(i));
                startActivity(intent);
            }
        });
    }
}