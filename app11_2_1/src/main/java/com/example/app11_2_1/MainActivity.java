package com.example.app11_2_1;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Load.LoaderCallbacks<String> {

    private final int TASK_ID = 0;
    public static TaskSample task;

    public static boolean isDialogCancel = false;
    private final String SAVE_MESSAGE = "saveMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if( savedInstanceState != null )
        {
            if ( task != null )
            {
                task.activity = this;
            }
        }

        Button button = ( Button )findViewById( R.id.amin_btnLoader );
        button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                Logger.log("非同期処理開始ボタンタップ" + getThread() );
                isDialogCancel = false;
                if( task != null )
                    task.progress = 0;
            }

            Loader loader = getSupportLoaderManager().getLo ader( TASK_ID );
            if( loader != null && loader.isStarted() )
            {
                Logger.log("destroyLoader()");
                getSupportLoaderManager().destroyLoader( TASK_ID );
            }

            Logger.log("restartLoader()");


        });
    }

    public static String getThread()
    {
        return String.format(" / %s", Thread.currentThread().getName() );
    }
}
