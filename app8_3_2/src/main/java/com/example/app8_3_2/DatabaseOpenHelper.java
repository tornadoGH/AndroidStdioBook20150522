package com.example.app8_3_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kooka on 2016/11/04.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "app832.db";
    private static final int DB_VERSION = 1;

    public DatabaseOpenHelper(Context context)
    {
        super( context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate( SQLiteDatabase db )
    {
        String sql = String.format("CREATE TABLE user( %s, %s, %s );",
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL",
                "name TEXT NOT NULL",
                "password TEXT NOT NULL");
        db.execSQL( sql );
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
    {

    }
}
