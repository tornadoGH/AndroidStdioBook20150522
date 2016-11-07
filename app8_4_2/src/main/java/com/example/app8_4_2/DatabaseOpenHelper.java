package com.example.app8_4_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 2016/11/07.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "app842.db";
    private static final int DB_VERSION = 1;

    public DatabaseOpenHelper( Context context )
    {
        super( context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate( SQLiteDatabase db )
    {
        db.execSQL( DaoItem.create() );
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
    {

    }
}
