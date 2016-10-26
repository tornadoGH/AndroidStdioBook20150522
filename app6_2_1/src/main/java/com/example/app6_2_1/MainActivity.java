package com.example.app6_2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvAction = ( TextView )findViewById( R.id.amin_txvAction );

        //  ボタンクリックリスナー
        Button button = ( Button )findViewById( R.id.amin_btnClick );
        button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                txvAction.setText( R.string.amin_txvActionClick );
            }
        });

        //  ボタンロングクリックリスナー
        Button buttonLong = ( Button )findViewById( R.id.amin_btnLongClick );
        buttonLong.setOnLongClickListener( new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick( View v )
            {
                txvAction.setText( R.string.amin_txvActionLongClick );
                return false;
            }
        });
    }
}
