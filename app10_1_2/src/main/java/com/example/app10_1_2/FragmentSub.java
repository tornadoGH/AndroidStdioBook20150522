package com.example.app10_1_2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created on 2016/11/09.
 */
public class FragmentSub extends Fragment {

    private Callback callback;
    private View rootView;
    private int count;

    public FragmentSub()
    {

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach( activity );

        //  アクティビティがコールバックを実装しているかチェックする
        try {
            callback = ( Callback )activity;
        } catch ( ClassCastException e )
        {
            throw new IllegalStateException("アクティビティがインターフェイスを実装していない");
        }
    }

    //  フラグメントのレイアウトを指定
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
    {
        count = 0;

        //  レイアウトの最上位Viewを取得
        rootView = inflater.inflate( R.layout.fragment_sub, container, false );

        //  フラグメント内のボタン取得
        Button button = ( Button )rootView.findViewById( R.id.fsub_btnFragment  );
        //  フラグメント内のボタンタップ時の処理
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                //  Activity側のコールバック呼び出し
                callback.onFragmentButtonClick( String.valueOf( count ));
            }
        });
        return rootView;
    }

    public void setText( String string )
    {
        (( TextView )rootView.findViewById( R.id.fsub_txvFragment )).setText( string );
    }

    public static interface Callback {

        public void onFragmentButtonClick( String string );
    }
}
