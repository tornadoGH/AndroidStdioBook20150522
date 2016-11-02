package com.example.app7_3_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_BROWSER = 1;
    private static final int ACTIVITY_PHONE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  ブラウザボタン
        findViewById( R.id.amin_btnBrowser ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse("http://www.ric.co.jp/telecom/"));
                startActivityForResult( intent, ACTIVITY_BROWSER );
            }
        });

        //  電話発信ボタンをクリック
        findViewById( R.id.amin_btnDialer ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse("tel:1234567890"));
                startActivityForResult( intent, ACTIVITY_PHONE );
            }
        });

        //  両方のアクティビティを呼び出す
        findViewById( R.id.amin_btnCallAll ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                startActivity( new Intent().setData( Uri.parse("sample://all")));
            }
        });

        //  アクティビティ１を呼び出す
        findViewById( R.id.amin_btnCallActivity1 ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent().setData( Uri.parse("sample://activity/one")));
            }
        });

        //  アクティビティ２を呼び出す
        findViewById( R.id.amin_btnCallActivity2 ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                startActivity( new Intent().setData( Uri.parse("sample://activity/two")));
            }
        });
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent intent )
    {
        super.onActivityResult( requestCode, resultCode, intent );

        switch( resultCode )
        {
            case ACTIVITY_BROWSER:
                Log.d("Debug","ブラウザからリターン");
                break;

            case ACTIVITY_PHONE:
                Log.d("Debug","電話からリターン");
                break;
        }

    }
}
