package com.example.app6_2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView txvFruits;
    public TextView txvFlowers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvFruits = ( TextView )findViewById( R.id.amin_txvFruits );
        txvFlowers = ( TextView )findViewById( R.id.amin_txvFlowers );

        //  Spinner項目が選択された時のリスナー
        Spinner spinner = ( Spinner )findViewById( R.id.amin_spnFruits );
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id )
            {
                String str = getResources().getStringArray( R.array.fruits )[position];
                txvFruits.setText( str );
            }

            @Override
            public void onNothingSelected( AdapterView<?> parent )
            {

            }
        });

        //  ListView項目が選択された時のリスナー
        ListView listView = ( ListView )findViewById( R.id.amin_lsvFlowers );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick( AdapterView<?> parent, View view, int position, long id )
            {
                String str = getResources().getStringArray( R.array.flowers )[position];
                txvFlowers.setText( str );
            }
        });
    }
}
