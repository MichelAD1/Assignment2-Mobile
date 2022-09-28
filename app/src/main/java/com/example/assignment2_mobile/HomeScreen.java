package com.example.assignment2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }
    public void go(View v){
        EditText name= (EditText) findViewById(R.id.name);
        String name_val=name.getText().toString();
        saveName(name);
        Intent i= new Intent(getApplicationContext(),FetchNews.class);
        i.putExtra("name",name_val);
        startActivity(i);
    }
    public void saveName(EditText text) {
        SharedPreferences sharedPref = getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("NAME", text.getText().toString());
        editor.apply();
    }
}