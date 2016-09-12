package com.example.app10_2_4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created on 2016/09/07.
 */
public class DialogManager extends DialogFragment {

    public static final String PARAM_ICON = "icon";
    public static final String PARAM_TITLE = "title";
    public static final String PARAM_MESSAGE = "message";
    public static final String PARAM_POVITIVE = "povitive";
    public static final String PARAM_NEGATIVE = "negative";
    public static final String PARAM_NEUTRL = "nautral";
    public static final String PARAM_CANCELABLE = "cancelable";

    public Callback callback;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach( activity );

        try {
            callback = ( Callback )activity;
        }
        catch ( ClassCastException e )
        {
            callback = null;
        }
    }

    //  ダイアログ外やバックボタンをタップした時
    @Override
    public void onActivityCreated( Bundle savedInstanceState )
    {
        super.onActivityCreated( savedInstanceState );
        getDialog().setCancelable( getArguments().getBoolean( PARAM_CANCELABLE ));
    }

    public static Dialog makeDialog(final Fragment fragment, final DialogInterface.OnClickListener listener, View view )
    {
        //  パラメータ取得
        Bundle args = fragment.getArguments();

        AlertDialog.Builder dialog = new AlertDialog.Builder( fragment.getActivity());

        if( args.containsKey( PARAM_ICON ))
        {
            dialog.setIcon( args.getInt( PARAM_ICON ));
        }
        if( args.containsKey( PARAM_POVITIVE ))
        {
            dialog.setPositiveButton( args.getInt( PARAM_POVITIVE ), listener );
        }
        if( args.containsKey( PARAM_NEGATIVE ))
        {
            dialog.setNegativeButton( args.getInt( PARAM_NEGATIVE ), listener );
        }
        if( args.containsKey( PARAM_NEUTRL ))
        {
            dialog.setNeutralButton( args.getInt( PARAM_NEUTRL), listener );
        }
        if( args.containsKey( PARAM_MESSAGE ))
        {
            dialog.setMessage(args.getString( PARAM_MESSAGE ));
        }
        dialog.setTitle( args.getInt( PARAM_TITLE ));

        if( view != null )
            dialog.setView( view );

        return dialog.create();
    }

    public static interface Callback {

        public void onDialogButtonClick(String tag, int which, Bundle bundle );
    }
}
