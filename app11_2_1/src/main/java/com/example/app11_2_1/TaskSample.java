package com.example.app11_2_1;

import android.app.Activity;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

/**
 * Created on 2016/09/12.
 */
public class TaskSample extends AsyncTaskLoader<String> {

    public static final int STATUS_NOT_START = 0;
    public static final int STATUS_CREATE = 1;
    public static final int STATUS_EXECUTE = 2;
    public static final int STATUS_FINISHED = 3;
    public static int status = STATUS_NOT_START;

    public int progress;
    public MainActivity activity;
    private boolean isTaskCancel = false;

    public TaskSample( MainActivity activity, int id )
    {
        super( activity.getApplicationContext() );

        Log.d("DEBUG", String.format("コンストラクタ ID=%d %s", String.valueOf(id), getThread() ));

        this.activity = activity;
    }

    @Override
    public String loadBackground()
    {
        Log.d("DEBUG", String.format("loadBackground() 非同期処理開始 %s", getThread() ));

        status = STATUS_EXECUTE;

        for( int i=progress;i<100;i++ )
        {
            DialogProgress dialog = ( DialogProgress )activity.getSupportFragmentManager().findFragmentByTag( DialogProgress.TAG );
            if( dialog != null )
            {
                isTaskCancel = dialog.isDialogCancel;
            }

            if( isTaskCancel || activity.isDialogCancel )
            {
                Log.d("DEBUG", "loadBackground()　非同期処理キャンセル " + isTaskCancel + ActivityMain.isDialogCancel() );
                isTaskCancel = false;
                MainActivity.isDialogCancel = false;

                return "非同期処理キャンセル";
            }

            try {
                Thread.sleep( 10 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }

            progress = i + 1;

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    ((TextView)activity.findViewById( R.id.amin_txvMessage )).setText( String.format("Progress = %s", String.valueOf( progress )));
                    ((TextView)activity.findViewById( R.id.amin_txvMessage )).setText( String.format("Progress = %s", String.valueOf( progress )));
                }
            });

            if( dialog != null )
                dialog.updateProgress( progress );
        }

        Log.d("Debug", "loadBackground() 非同期処理終了" );
        return "非同期処理終了";
    }

    @Override
    protected  void onStartLoading()
    {
//        Log.d()

    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus( int status )
    {
        TaskSample.status = status;
    }

    public static String getThread()
    {
        return String.format(" / %s", Thread.currentThread().getName());
    }
}
