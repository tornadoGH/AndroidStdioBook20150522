package com.example.app8_4_2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvCount;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  レコード件数取得
        txvCount = ( TextView )findViewById( R.id.amin_txvCount );
        txvCount.setText( String.valueOf( DaoItem.count( getApplicationContext() )));

        //  DB取得
        db = new DatabaseOpenHelper( getApplicationContext()).getWritableDatabase();

        findViewById( R.id.amin_btnInsert ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                db.beginTransaction();  //  トランザクション開始
                try {
                    //  レコード作成
                    DtoItem item = new DtoItem();
                    item.name = "サンプル";
                    item.price = 12345;

                    //  レコード追加
                    DaoItem.insert( db, item );

                    db.setTransactionSuccessful();  //  コミット
                }
                finally {
                    //  レコード件数表示
                    txvCount.setText( String.valueOf( DaoItem.count( db )));
                    db.endTransaction();    //  トランザクション終了
                }
            }
        });
    }
}
