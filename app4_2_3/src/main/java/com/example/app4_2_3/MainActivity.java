package com.example.app4_2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  ベースのレイアウト
        LinearLayout layout = new LinearLayout( this );
        layout.setLayoutParams( new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        layout.setOrientation( LinearLayout.VERTICAL );
        layout.setPadding( 10, 10, 10, 10 );

        //  ボタン配置するレイアウト（横並び）
        LinearLayout layoutHorizontal = new LinearLayout( this );
        layoutHorizontal.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        layoutHorizontal.setOrientation( LinearLayout.HORIZONTAL );

        //  ボタン
        Button button = new Button( this );
        button.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        button.setText("ボタン");

        Button button2 = new Button( this );
        button2.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        button2.setText("ボタン");

        Button button3 = new Button( this );
        button3.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        button3.setText("ボタン");

        //  テキスト
        TextView textView1 = new TextView( this );
        textView1.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        textView1.setText("テキスト1");
        textView1.setTextAppearance( this, android.R.style.TextAppearance_Large );

        TextView textView2 = new TextView( this );
        textView2.setLayoutParams( new LinearLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT ));
        textView2.setText("テキスト2");
        textView2.setTextAppearance( this, android.R.style.TextAppearance_Large );

        //  ベースのレイアウトにボタンを配置するレイアウトを追加
        layout.addView( layoutHorizontal );

        //  ベースのレイアウトにテキストビューを２つ追加
        layout.addView( textView1 );
        layout.addView( textView2 );

        //  ボタンを配置するレイアウトにボタンを配置
        layoutHorizontal.addView( button );
        layoutHorizontal.addView( button2 );
        layoutHorizontal.addView( button3 );

        setContentView( layout );
    }
}
