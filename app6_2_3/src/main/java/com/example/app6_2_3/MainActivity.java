package com.example.app6_2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public CheckBox chkRadioEnabled;
    public RadioButton rbtCheckEnabled;
    public RadioButton rbtCheckDisabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkRadioEnabled = ( CheckBox )findViewById( R.id.amin_chkRadioEnabled );
        rbtCheckEnabled = ( RadioButton )findViewById( R.id.amin_rbtCheckEnabled );
        rbtCheckDisabled = ( RadioButton )findViewById( R.id.amin_rbtCheckDisabled );

        //  チェックボックスのチェック変更リスナー
        chkRadioEnabled.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked )
            {
                rbtCheckEnabled.setEnabled( isChecked );
                rbtCheckDisabled.setEnabled( isChecked );
            }
        });

        //  ラジオボタンのチェック変更リスナー
        rbtCheckEnabled.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged( CompoundButton buttonView, boolean isChecked )
            {
                chkRadioEnabled.setEnabled( isChecked );
            }
        });
    }
}
