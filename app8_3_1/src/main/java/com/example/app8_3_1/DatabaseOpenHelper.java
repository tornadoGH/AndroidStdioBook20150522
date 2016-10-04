package com.example.app8_3_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    //  データベース名
    private static final String DB_NAME = "app831.d";
    //  データベースのバージョン
    private static final int DB_VERSION = 1;

    public DatabaseOpenHelper(Context context)
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
