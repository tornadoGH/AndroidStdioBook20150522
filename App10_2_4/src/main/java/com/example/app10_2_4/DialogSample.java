package com.example.app10_2_4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 2016/09/07.
 */
public class DialogSample extends DialogManager {

    public static final String TAG = "TagDialogRegister";
    public static final String PARAM_ACTIVITY_TEXT = "activityText";
    public static final String PARAM_DIALOG_TEXT = "dialogText";

    private EditText etxSendActivityText;

    public DialogSample()
    {

    }

    @Override
    public final Dialog onCreateDialog( Bundle savedInstanceState )
    {
        LayoutInflater inflater = ( LayoutInflater )getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE );

        View view = inflater.inflate( R.layout.dialog_sample, null );

        //  アクティビティでバンドルに保存した文字列を取得する
        String activityText = getArguments().getString( PARAM_ACTIVITY_TEXT );
        Log.d("DEBUG", activityText);

        //  受信テキストのTextViewにバンドルから取得した文字列をセット
        TextView textView = ( TextView )view.findViewById( R.id.dsam_txvReceiveActivityText );
        textView.setText( activityText );

        //  ダイアログからアクティビティに送信するテキスト
        etxSendActivityText = ( EditText )view.findViewById( R.id.dsam_etxSendActivityText );

        //  ダイアログボタンを押した時の処理
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){

            @Override
            public void onClick( DialogInterface dialog, int which )
            {
                //  送信テキストEditTextの文字列をバンドルに保存
                Bundle bundle = new Bundle();
                bundle.putString( PARAM_DIALOG_TEXT, etxSendActivityText.getText().toString() );

                //  MainAvcitiyのメソッドをコールバックで呼ぶ
                callback.onDialogButtonClick( getTag(), which, bundle );
            }
        };

        //  ダイアログ生成
        return makeDialog( this, listener, view );
    }

    public static DialogSample create( DialogParams params )
    {
//        params.icon( null );
        params.title( R.string.dsam_title );
        params.positive( R.string.dsam_positive );
        params.negative( R.string.dsam_negative );

        DialogSample dialog = new DialogSample();
        dialog.setArguments( params.getBundle());

        return dialog;
    }

}
