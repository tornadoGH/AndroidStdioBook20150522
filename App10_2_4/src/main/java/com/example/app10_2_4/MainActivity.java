package com.example.app10_2_4;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogManager.Callback {

    private CheckBox chkCancelable;      //  ダイアログのキャンセル可/不可を設定する為のチェックボックス
                                            //  可にするとダイアログ表示中にバックボタンorダイアログ外をタップするとダイアログがキャンセルされる
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCancelable = ( CheckBox )findViewById( R.id.amin_chkCancelLabel );

        //  ダイアログ表示ボタン
        Button button = ( Button )findViewById( R.id.amin_btnDialog );
        button.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                //  送信テキストEditboxの文字列を取得
                EditText editText = ( EditText )findViewById( R.id.amin_etxSendDialogText );
                String putString = editText.getText().toString();

                //  ダイアログパラメータ生成
                DialogParams params = new DialogParams();
                params.addString( DialogSample.PARAM_ACTIVITY_TEXT, putString );    //  Bundleに送信テキストEtitBoxの文字列を保存する
                params.canceLabel( chkCancelable.isChecked() );

                //  ダイアログ生成
                DialogSample dialogSample = new DialogSample();
                dialogSample = dialogSample.create( params );
                dialogSample.show( getSupportFragmentManager(), DialogSample.TAG );
//              new DialogSample().create( params ).show( getSupportFragmentManager(), DialogSample.TAG );
            }
        });
    }

    //  ダイアログからのコールバック
    @Override
    public void onDialogButtonClick( String tag, int which, Bundle bundle )
    {
        //  どのダイアログからかを判定する
        if( tag.equals( DialogSample.TAG ))
        {
            //  何のボタンかを判定する
            if( which == DialogInterface.BUTTON_POSITIVE )
            {
                //  受信テキストのTextViewにバンドルの文字列をセットする
                TextView textView = ( TextView )findViewById( R.id.amin_txvReceiveDialogText );
                textView.setText( bundle.getString( DialogSample.PARAM_DIALOG_TEXT ));
            }
        }
    }
}
