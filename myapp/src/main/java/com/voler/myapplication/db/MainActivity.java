package com.voler.myapplication.db;

import android.app.Activity;
import android.os.Bundle;

import com.voler.myapplication.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDBOpenHelper helper = new MyDBOpenHelper(this);
        helper.getWritableDatabase();
    }


    
}
