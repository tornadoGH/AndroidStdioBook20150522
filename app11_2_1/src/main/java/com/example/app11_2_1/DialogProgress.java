package com.example.app11_2_1;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created on 2016/09/12.
 */
public class DialogProgress extends DialogProgressManager {

    public static final String TAG = "TagDialogProgress";

    private ProgressDialog dialog;
    public boolean isDialogCancel = false;

    public DialogProgress(){}

    @Override
    public final Dialog onCreateDialog( Bundle savedInstanceState )
    {
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick( DialogInterface dialog, int which )
            {
                if( which == DialogInterface.BUTTON_NEGATIVE )
                {
                    isDialogCancel = true;
                    MainActivity.isDialogCancel = true;
                }
            }
        };

        dialog = makeDialog( this, listener );
        return dialog;
    }

    public static DialogProgress create( Context context, int progress )
    {
        DialogParams params = new DialogParams()
                .title( R.string.dprg_title )
                .message( context.getString( R.string.dprg_message ))
                .negative( R.string.dprg_negative )
                .addInteger( DialogProgressManager.PARAM_PROGRESS_STYLE, ProgressDialog.STYLE_HORIZONTAL )
                .addInteger( DialogProgressManager.PARAM_MAX, 100 )
                .addInteger( DialogProgressManager.PARAM_PROGRESS, progress );

        DialogProgress dialog = new DialogProgress();
        dialog.setArguments( params.getBundle() );

        return dialog;
    }

    public void updateProgress( int value )
    {
        if( dialog != null )
            dialog.setProgress( value );
    }
}
