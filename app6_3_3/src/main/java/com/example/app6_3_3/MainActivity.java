package com.example.app6_3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvCount = ( TextView )findViewById( R.id.amin_txvOutput );

        //  ボタンのリスナー
        findViewById( R.id.amin_btnChange ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                txvCount.setText( getText( R.string.amin_txvAfter ));
            }
        });
    }

    //  画面が破棄される前に情報を保存
    protected void onSaveInstanceState( Bundle outState )
    {
        super.onSaveInstanceState( outState );

        //  Bundleにテキスト保存
        outState.putString("Output", txvCount.getText().toString() );
    }

    //  画面が復元される際に状態を取り出す
    protected void onRestoreInstanceState( Bundle savedInstanceState )
    {
        super.onRestoreInstanceState( savedInstanceState );

        //  Bundleからテキスト取得
        txvCount.setText( savedInstanceState.getString("Output"));
    }
}
