package com.example.app9_2_1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etxValue;
    private TextView txvValue;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxValue = ( EditText )findViewById( R.id.amin_etxValue );
        txvValue = ( TextView )findViewById( R.id.amin_txvValue );

        preferences = getSharedPreferences("shared", MODE_PRIVATE );

        //  ラジオボタンの選択時処理
        RadioGroup radioGroup = ( RadioGroup )findViewById( R.id.amin_rdgName );
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch ( checkedId )
                {
                    case R.id.amin_rdbAnyName:
                        preferences = getSharedPreferences("shared", MODE_PRIVATE );
                        break;

                    case R.id.amin_rdbActivityName:
                        preferences = getPreferences( MODE_PRIVATE );
                        break;

                    case R.id.amin_rdbDefaultName:
                        preferences = PreferenceManager.getDefaultSharedPreferences( getBaseContext() );
                        break;
                }
            }
        });

        //  書き込みボタン処理
        Button button1 = ( Button )findViewById( R.id.amin_btnSave );
        button1.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("key", etxValue.getText().toString() );
                editor.commit();
                txvValue.setText("");
            }
        });

        //  読み出しボタン処理
        Button button2 = ( Button )findViewById( R.id.amin_btnLoad );
        button2.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                txvValue.setText( preferences.getString("key","データがありません"));
            }
        });

        //  削除ボタン処理
        Button button3 = ( Button )findViewById( R.id.amin_btnDelete );
        button3.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("key");
                editor.commit();
                txvValue.setText("");
            }
        });
    }
}
