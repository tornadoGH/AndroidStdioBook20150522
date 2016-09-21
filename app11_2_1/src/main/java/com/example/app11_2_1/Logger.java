package com.example.app11_2_1;

import android.util.Log;

/**
 * Created on 2016/09/20.
 */
public class Logger {

    public static void log( String msg ){

        StackTraceElement calledClass = Thread.currentThread().getStackTrace()[3];
        Log.d("APPDEBUG:" + calledClass.getFileName() + ":" + calledClass.getLineNumber(), msg);
    }
}
