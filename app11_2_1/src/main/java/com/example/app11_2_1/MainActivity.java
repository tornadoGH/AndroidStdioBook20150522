package com.example.app11_2_1;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private final int TASK_ID = 0;
    public static TaskSample task;

    public static boolean isDialogCancel = false;
    private final String SAVE_MESSAGE = "saveMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            if (task != null) {
                task.activity = this;
            }
        }

        Button button = (Button) findViewById(R.id.amin_btnLoader);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.log("非同期処理開始ボタンタップ" + getThread());
                isDialogCancel = false;
                if (task != null)
                    task.progress = 0;
            }

            Loader loader = getSupportLoaderManager().getLoader( TASK_ID );
            if( loader != null )
            {
                Logger.log("destroyLoader()");
                getSupportLoaderManager().destroyLoader(TASK_ID);
            }
        });
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Log.d("App11_2_1","onCreateLoader()" + getThread() );
        return null;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
        Log.d("App11_2_1", "onLoadFinished()" + getThread());
        ((TextView) findViewById(R.id.amin_txvMessage)).setText(result);

        //  ダイアログ削除
        DialogProgress dialog = (DialogProgress)getSupportFragmentManager().findFragmentByTag(DialogProgress.TAG);
        if (dialog != null) {
            dialog.onDismiss(dialog.getDialog());
        }
        task.setStatus(TaskSample.STATUS_FINISHED);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        Log.d("App11_2_1", "onLoadReset()" + getThread());
    }

    public static String getThread() {
        return String.format(" / %s", Thread.currentThread().getName());
    }


}
