package com.github.farafonoff.advancedviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.farafonoff.advancedviews.dummy.DummyItems;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Artem_Farafonov on 12/14/2015.
 */
public class ArrayAdapterWithImages extends ArrayAdapter<DummyItems.DummyItem> {

    int mResourceId;

    public ArrayAdapterWithImages(Context context, int resource, List<DummyItems.DummyItem> objects) {
        super(context, 0, objects);
        this.mResourceId = resource;
    }

    static class MyViewHolder {
        ImageView imageref;
        TextView textref;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DummyItems.DummyItem item = getItem(position);
        MyViewHolder holder;
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(mResourceId, null);
            holder = new MyViewHolder();
            holder.imageref = (ImageView) convertView.findViewById(R.id.item_img);
            holder.textref = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.imageref.setBackgroundColor(0);
        /*Glide.with(getContext())
                .load(item.getImageUri())
                .centerCrop()
                .crossFade()
                .into(holder.imageref);*/
        Picasso.with(getContext())
                .load(item.getImageUri())
                .into(holder.imageref);
        holder.textref.setText(item.getWord());
        return convertView;
    }
}
