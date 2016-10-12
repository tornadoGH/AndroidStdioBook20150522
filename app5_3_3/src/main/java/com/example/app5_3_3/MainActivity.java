package com.example.app5_3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lsvItem = ( ListView )findViewById( R.id.amin_lsvItem );

        //  アダプタにセットするデータを作成
        String[] items = {"えんぴつ","消しゴム","コンパス","分度器","ボールペン"};
        int[] prices = { 80, 100, 300, 200, 150 };

        List<BeanItem> beans = new ArrayList<>();
        for( int i=0;i<items.length;i++ )
        {
            BeanItem bean = new BeanItem();
            bean.item = items[i];
            bean.price = prices[i];
            beans.add( bean );
        }

        //  アダプタの定義とListViewにアダプタをセット
        AdapterListItem adapter = new AdapterListItem( this, 0, beans );
        lsvItem.setAdapter( adapter );
    }
}
