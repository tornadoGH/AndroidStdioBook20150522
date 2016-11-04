package com.example.app8_3_2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  データベースを読み取り専用でオープンする
        DatabaseOpenHelper helper = new DatabaseOpenHelper( getApplicationContext() );
        SQLiteDatabase db = helper.getReadableDatabase();
    }
}
