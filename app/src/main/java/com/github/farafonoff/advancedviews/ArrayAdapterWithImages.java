package com.github.farafonoff.advancedviews;

import android.content.Context;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.farafonoff.advancedviews.dummy.DummyClickListener;
import com.github.farafonoff.advancedviews.dummy.DummyItems;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Artem_Farafonov on 12/14/2015.
 */
public class ArrayAdapterWithImages extends RecyclerView.Adapter<ArrayAdapterWithImages.MyViewHolder> implements View.OnClickListener {

    int mResourceId;
    Context context;
    List<DummyItems.DummyItem> objects;
    private DummyClickListener onClickListener;

    public ArrayAdapterWithImages(Context context, int resource, List<DummyItems.DummyItem> objects) {
        super();
        this.mResourceId = resource;
        this.objects = objects;
        this.context = context;
        if (objects instanceof ObservableList) {
            ObservableList observable = (ObservableList) objects;
            observable.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList>() {
                @Override
                public void onChanged(ObservableList sender) {
                    ArrayAdapterWithImages.this.notifyDataSetChanged();
                }

                @Override
                public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                    ArrayAdapterWithImages.this.notifyItemRangeChanged(positionStart, itemCount);
                }

                @Override
                public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                    ArrayAdapterWithImages.this.notifyItemRangeInserted(positionStart, itemCount);
                }

                @Override
                public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
                    ArrayAdapterWithImages.this.notifyDataSetChanged();
                }

                @Override
                public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                    ArrayAdapterWithImages.this.notifyItemRangeRemoved(positionStart, itemCount);
                }
            });
        }
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
        holder.rootView.setTag(item.getWord());
        holder.rootView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public void setOnClickListener(DummyClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {
        if (onClickListener!=null) {
            onClickListener.onClick((String)v.getTag());
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageref;
        TextView textref;
        View rootView;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            imageref = (ImageView) itemView.findViewById(R.id.item_img);
            textref = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
