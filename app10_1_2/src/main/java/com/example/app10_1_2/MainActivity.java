package com.example.app10_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentSub.Callback {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;

        //  アクティビティ内のボタンタップ
        Button button = (Button) findViewById(R.id.amin_btnActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                count++;

                FragmentSub fs = ( FragmentSub )getFragmentManager().findFragmentById( R.id.amin_frgSub );
                fs.setText( String.valueOf( count ));
            }
        });
    }

    @Override
    public void onFragmentButtonClick( String string )
    {
        TextView textView = ( TextView )findViewById( R.id.amin_txvActivity );
        textView.setText( string );
    }
}
