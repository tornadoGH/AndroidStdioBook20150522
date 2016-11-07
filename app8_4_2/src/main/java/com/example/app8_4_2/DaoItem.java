package com.example.app8_4_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created on 2016/11/07.
 */
public class DaoItem {

    public static String TABLE_NAME = "item";
    public static String COLUMN_ID = "_id";
    public static String COLUMN_NAME = "name";
    public static String COLUMN_PRICE = "price";

    public static String create()
    {
        String sql = String.format("CREATE TABLE %s( " +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s INTEGER NOT NULL );", TABLE_NAME, COLUMN_ID, COLUMN_NAME, COLUMN_PRICE );
        return sql;
    }

    public static long insert( SQLiteDatabase db, DtoItem item )
    {
        ContentValues values = new ContentValues();
        values.put( COLUMN_NAME, item.name );
        values.put( COLUMN_PRICE, item.price );

        return db.insert( TABLE_NAME, null, values );
    }

    public static long count( Context context )
    {
        DatabaseOpenHelper helper = new DatabaseOpenHelper( context );
        SQLiteDatabase db = helper.getReadableDatabase();

        return DatabaseUtils.queryNumEntries( db, TABLE_NAME );
    }

    public static long count( SQLiteDatabase db )
    {
        return DatabaseUtils.queryNumEntries( db, TABLE_NAME );
    }
}
