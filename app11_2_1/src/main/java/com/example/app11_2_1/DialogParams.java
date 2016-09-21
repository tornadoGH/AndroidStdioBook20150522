package com.example.app11_2_1;

import android.os.Bundle;

/**
 * Created on 2016/09/14.
 */
public class DialogParams {

    private Bundle bundle;

    public DialogParams()
    {
        bundle = new Bundle();
    }

    public DialogParams icon( int icon )
    {
        bundle.putInt( DialogProgressManager.PARAM_ICON, icon );
        return this;
    }

    public DialogParams title( int title )
    {
        bundle.putInt( DialogProgressManager.PARAM_TITLE, title );
        return this;
    }

    public DialogParams message( String message )
    {
        bundle.putString( DialogProgressManager.PARAM_MESSAGE, message );
        return this;
    }

    public DialogParams positive( int positive )
    {
        bundle.putInt( DialogProgressManager.PARAM_POVITIVE, positive );
        return this;
    }

    public DialogParams neutral( int neutral )
    {
        bundle.putInt( DialogProgressManager.PARAM_NEUTRL, neutral );
        return this;
    }

    public DialogParams negative( int negative )
    {
        bundle.putInt( DialogProgressManager.PARAM_NEGATIVE, negative );
        return this;
    }

    public DialogParams canceLabel( boolean cancelable )
    {
        bundle.putBoolean( DialogProgressManager.PARAM_CANCELABLE, cancelable );
        return this;
    }

    public DialogParams addString( String key, String value )
    {
        bundle.putString( key, value );
        return this;
    }

    public DialogParams addInteger( String key, Integer value )
    {
        bundle.putInt( key, value );
        return this;
    }

    public Bundle getBundle()
    {
        return bundle;
    }
}
