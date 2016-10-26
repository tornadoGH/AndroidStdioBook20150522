package com.example.app5_4_4;

import android.content.res.Configuration;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drwMain;
    private ActionBarDrawerToggle toggle;
    private TextView txvMessage;
    private ListView lsvDrawer;
    private final String[] items = new String[]{"メニュー１","メニュー２","メニュー３",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvMessage = ( TextView )findViewById( R.id.txvMessage );

        //  ツールバーの取得とアクティビティへの通知
        Toolbar tlbMain = ( Toolbar )findViewById( R.id.tblMain );
        setSupportActionBar( tlbMain );
        drwMain = ( DrawerLayout )findViewById( R.id.drwMain );

        //  ツールバーの一番左にトグルボタンを設定
        toggle = new ActionBarDrawerToggle( this, drwMain, tlbMain, R.string.app_name, R.string.app_name );
        toggle.setDrawerIndicatorEnabled( true );
        drwMain.setDrawerListener( toggle );    //  非推奨
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );

        //  ナビゲーションドロワの中のリストビュー定義
        lsvDrawer = ( ListView )findViewById( R.id.lsvDrawer );
        lsvDrawer.setAdapter( new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, items ));
        lsvDrawer.setOnItemClickListener( new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id )
            {
                txvMessage.setText( items[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        getMenuInflater().inflate( R.menu.menu_activity_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        switch ( item.getItemId() )
        {
            case R.id.action_call:
                txvMessage.setText( R.string.action_call );
                return true;

            case R.id.action_search:
                txvMessage.setText( R.string.action_search );
                return true;

            case R.id.action_save:
                txvMessage.setText( R.string.action_save );
                return true;
        }

        return( toggle.onOptionsItemSelected( item ) || super.onOptionsItemSelected( item ));
    }

    @Override
    protected void onPostCreate( Bundle savedInstanceState )
    {
        super.onPostCreate( savedInstanceState );

        //  トグルボタンを同期
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged( Configuration newConfig )
    {
        super.onConfigurationChanged( newConfig );
        toggle.onConfigurationChanged( newConfig );
    }
}
