package com.example.app7_2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String INPUT_TEXT = "InputText";
    private EditText etxInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxInput = ( EditText )findViewById( R.id.amin_extInput );

        Button button = ( Button )findViewById( R.id.amin_btnIntent );
        button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                Intent intent = new Intent( getApplicationContext(), ActivitySub.class );
                intent.putExtra( INPUT_TEXT, etxInput.getText().toString() );
                startActivity( intent );
            }
        });
    }
}
