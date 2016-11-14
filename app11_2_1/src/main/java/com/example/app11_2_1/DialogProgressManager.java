package com.example.app11_2_1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

/**
 * Created on 2016/09/12.
 */
public class DialogProgressManager extends DialogFragment {

    public static final String PARAM_ICON = "icon";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_MESSAGE = "message";
    public static final String PARAM_POSITIVE = "positive";
    public static final String PARAM_NEGATIVE = "negative";
    public static final String PARAM_NEUTRAL = "neutral";
    public static final String PARAM_CANCELABLE = "cancelable";
    public static final String PARAM_PROGRESS_STYLE = "progressStyle";
    public static final String PARAM_MAX = "max";
    public static final String PARAM_PROGRESS = "progress";

    public Callback calback;

    @Override
    public void onAttach( Activity activity )
    {
        super.onAttach(activity);

        try {
            calback = (Callback) activity;
        }
        catch (ClassCastException e)
        {
            calback = null;
        }
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState )
    {
        super.onActivityCreated( savedInstanceState );
        getDialog().setCancelable( getArguments().getBoolean( PARAM_CANCELABLE ));
    }

    public static ProgressDialog makeDialog(final Fragment fragment, final DialogInterface.OnClickListener listener )
    {
        Bundle args = fragment.getArguments();
        Context context = fragment.getActivity();

        ProgressDialog dialog = new ProgressDialog( context );

        if( args.containsKey( PARAM_ICON ))
        {
            dialog.setIcon( args.getInt( PARAM_ICON ));
        }
        if( args.containsKey( PARAM_POSITIVE ))
        {
            dialog.setButton( DialogInterface.BUTTON_POSITIVE, context.getText( args.getInt( PARAM_POSITIVE )), listener );
        }
        if( args.containsKey( PARAM_NEGATIVE ))
        {
            dialog.setButton( DialogInterface.BUTTON_NEGATIVE, context.getText( args.getInt( PARAM_NEGATIVE )), listener );
        }
        if( args.containsKey( PARAM_NEUTRAL ))
        {
            dialog.setButton( DialogInterface.BUTTON_NEUTRAL, context.getText( args.getInt( PARAM_NEUTRAL )), listener );
        }
        if( args.containsKey( PARAM_MESSAGE ))
        {
            dialog.setMessage( args.getString( PARAM_MESSAGE ));
        }
        if( args.containsKey( PARAM_PROGRESS_STYLE ))
        {
            dialog.setProgressStyle( args.getInt( PARAM_PROGRESS_STYLE ));
        }
        if( args.containsKey( PARAM_MAX ))
        {
            dialog.setMax( args.getInt( PARAM_MAX ));
        }
        if( args.containsKey( PARAM_PROGRESS ))
        {
            dialog.setProgressStyle(args.getInt( PARAM_PROGRESS ));
        }
        dialog.setTitle( args.getInt( PARAM_TITLE ));

        return dialog;
    }

    public static interface Callback
    {
        public void onDialogButtonClick( String tag, int which, Bundle bundle );
    }
}
