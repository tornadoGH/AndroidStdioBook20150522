package com.example.app5_3_3;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created 2016/10/11.
 */
public class AdapterListItem extends ArrayAdapter<BeanItem> {

    public AdapterListItem( Context context, int resource, List<BeanItem> objects )
    {
        super( context, resource, objects );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent )
    {
        ViewHolder holder;

        if( convertView == null )
        {
            LayoutInflater inflater = ( LayoutInflater )getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( R.layout.list_item, null );
            holder = new ViewHolder( convertView );
            convertView.setTag( holder );   //  メモリ上に保存
        }
        else
        {
            holder = ( ViewHolder )convertView.getTag();    //  setTagでメモリに保存されているデータを取得
        }

        BeanItem bean = getItem( position );

        holder.txvItem.setText( bean.item );
        holder.txvPrice.setText("￥" + Integer.toString( bean.price ));

        return convertView;
    }

    private static class ViewHolder
    {
        public TextView txvItem;
        public TextView txvPrice;

        public ViewHolder( View view )
        {
            txvItem = ( TextView )view.findViewById( R.id.list_txtItem );
            txvPrice = ( TextView )view.findViewById( R.id.list_txtPrice );
        }
    }
}
