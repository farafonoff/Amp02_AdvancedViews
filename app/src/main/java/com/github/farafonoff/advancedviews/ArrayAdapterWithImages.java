package com.github.farafonoff.advancedviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class ArrayAdapterWithImages extends RecyclerView.Adapter<ArrayAdapterWithImages.MyViewHolder> {

    int mResourceId;
    Context context;
    List<DummyItems.DummyItem> objects;

    public ArrayAdapterWithImages(Context context, int resource, List<DummyItems.DummyItem> objects) {
        super();
        this.mResourceId = resource;
        this.objects = objects;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(mResourceId, null);
        MyViewHolder holder = new MyViewHolder(convertView);
        convertView.setTag(holder);
        parent.addView(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageref.setBackgroundColor(0);
        DummyItems.DummyItem item = objects.get(position);
        Picasso.with(context)
                .load(item.getImageUri())
                .into(holder.imageref);
        holder.textref.setText(item.getWord());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageref;
        TextView textref;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageref = (ImageView) itemView.findViewById(R.id.item_img);
            textref = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

}
