package com.example.admin.w5test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.w5test.model.*;
import com.bumptech.glide.Glide;
import com.example.admin.w5test.model.Flickr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/29/2017.
 */

public class FlickrAdapter extends RecyclerView.Adapter<FlickrAdapter.ViewHolder> {

    private Flickr flickr;
    private Context context;

    public FlickrAdapter(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override

    public FlickrAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .flickr_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlickrAdapter.ViewHolder holder, int position) {
        Item item = flickr.getItems().get(position);
        holder.tvTitle
                .setText(item.getTitle());
        holder.tvAuthor
                .setText(item.getAuthor());
        Glide.with(holder.itemView.getContext())
                .load(item.getMedia().getM()).into(holder.imageView);

    }

    @Override
    public int getItemCount() { return flickr.getItems().size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvAuthor;
        private final TextView tvTitle;
        private final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);

        }
    }
}
