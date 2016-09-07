package com.example.app1012;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created on 2016/09/06.
 */
public class FragmentSub extends android.support.v4.app.Fragment {

    private Callback callback;
    private View rootView;
    private int count;

    public FragmentSub()
    {
        Log.d("FragmentSub","FragmentSub()");
    }

    @Override
    public void onAttach(Activity activity)
    {
        Log.d("FragmentSub","onAttach");

        super.onAttach( activity );

        try {
            callback = ( Callback )activity;
        }
        catch ( ClassCastException e )
        {
            throw new IllegalStateException("アクティビティがインターフェイスを実装していません", e );
        }
    }

    //  フラグメントレイアウトの指定
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savevdInstanceState )
    {
        Log.d("FragmentSub","onCreateView()");
        count = 0;

        //  レイアウトの最上位のViewを取得
        rootView = inflater.inflate( R.layout.fragment_sub, container, false );

        //  フラグメントに配置したボタンのリスナー
        Button button = ( Button )rootView.findViewById( R.id.fsub_btnFragment );
        button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                Log.d("FragmentSub","onClick");
                count++;

                //  MainActivityの onFragmentButtonClick メソッドが呼ばれる
                callback.onFragmentButtonClick( String.valueOf( count ));
            }
        });
        return rootView;
    }

    //  アクティビティからのTextView更新用メソッド
    public void setText( String string )
    {
        Log.d("FragmentSub","setText");
        TextView textView = ( TextView )rootView.findViewById( R.id.fsub_txvFragment );
        textView.setText( string );
    }

    public static interface Callback {
        public void onFragmentButtonClick( String string );
    }
}
