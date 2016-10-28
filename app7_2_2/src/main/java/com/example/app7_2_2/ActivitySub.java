package com.example.app7_2_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created on 2016/10/28.
 */
public class ActivitySub extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sub );

        TextView txvOutput = ( TextView )findViewById( R.id.asub_txvOutput );
        txvOutput.setText( getIntent().getStringExtra( MainActivity.INPUT_TEXT ));
    }
}
