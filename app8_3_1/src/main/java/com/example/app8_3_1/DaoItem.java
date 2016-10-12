package com.example.app8_3_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/09/23.
 */
public class DaoItem {

    public static String TABLE_NAME = "item";
    public static String COLUM_ID = "_id";
    public static String COLUM_NAME = "name";
    public static String COLUM_PRICE = "price";

    public static String create()
    {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUM_ID + "integer primary key autoincrement not null, " +
                COLUM_NAME + "text not null," +
                COLUM_PRICE + "integer not null" +
                ");";
        return sql;
    }

    public static DtoItem findById( Context context, long id )
    {
        SQLiteDatabase db = getReadableDB( context );

        DtoItem item = new DtoItem();

        Cursor cursor = db.rawQuery( String.format("SELECT * FROM %s WHERE _id = ?", TABLE_NAME  ),
                new String[]{ String.valueOf( id )} );
        if( cursor.moveToFirst())
        {
            item.id = cursor.getLong( 0 );
            item.name = cursor.getString( 1 );
            item.price = cursor.getInt( 2 );
        }
        cursor.close();
        return item;
    }

    public static List<DtoItem> findAll( Context context )
    {
        SQLiteDatabase db = getReadableDB( context );

        List<DtoItem> listItem = new ArrayList<DtoItem>();

        Cursor cursor = db.rawQuery( String.format("SELECT * FROM %s ORDER BY %s", TABLE_NAME, COLUM_ID ), null );
        if( cursor.moveToFirst())
        {
            do {
                DtoItem item = new DtoItem();

                item.id = cursor.getLong( 0 );
                item.name = cursor.getString( 1 );
                item.price = cursor.getInt( 2 );

                listItem.add( item );
            } while( cursor.moveToNext() );
        }

        cursor.close();
        return listItem;
    }

    public static long insert( Context context, DtoItem item )
    {
        SQLiteDatabase db = getWritableDB( context );

        ContentValues values = new ContentValues();
        values.put( COLUM_NAME, item.name );
        values.put( COLUM_PRICE, item.price );

        return db.insert( TABLE_NAME, null, values );
    }

    public static long update( Context context, DtoItem item )
    {
        SQLiteDatabase db = getWritableDB( context );

        ContentValues values = new ContentValues();
        values.put( COLUM_NAME, item.name );
        values.put( COLUM_PRICE, item.price );

        return db.update( TABLE_NAME, values, String.format("%d = ?", COLUM_ID ), new String[]{ String.valueOf( item.id )});
    }

    public static long delete( Context context, long id )
    {
        SQLiteDatabase db = getWritableDB( context );

        return db.delete( TABLE_NAME, String.format("%d = ?", COLUM_ID ), new String[]{ String.valueOf( id )});
    }

    //  読み取り専用でDB取得
    private static SQLiteDatabase getReadableDB( Context context )
    {
        DatabaseOpenHelper helper = new DatabaseOpenHelper( context );
        return helper.getWritableDatabase();
    }

    //  書き込み可能でDB取得
    private static SQLiteDatabase getWritableDB( Context context )
    {
        DatabaseOpenHelper helper = new DatabaseOpenHelper( context );
        return helper.getWritableDatabase();
    }
}
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　