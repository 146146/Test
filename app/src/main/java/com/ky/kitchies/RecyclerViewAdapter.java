package com.ky.kitchies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by k on 08-02-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mcontext;
    private List<Category> mdata;

    public RecyclerViewAdapter(Context mcontext, List<Category> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflator = LayoutInflater.from(mcontext);
        view = mInflator.inflate(R.layout.cardview_item_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_category_title.setText(mdata.get(position).getTitle());
        //local image load
        //holder.img_category_thumbnail.setImageResource(mdata.get(position).getThumbnail());
        Picasso.with(mcontext).load(mdata.get(position).getThumbnail()).into(holder.img_category_thumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mcontext,CategoryDetail.class);
                intent.putExtra("Title",mdata.get(position).getTitle());
                intent.putExtra("Description",mdata.get(position).getDescription());
                intent.putExtra("Category",mdata.get(position).getCategory());
                intent.putExtra("Thumbnail",mdata.get(position).getThumbnail());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_category_title;
        ImageView img_category_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_category_title = (TextView) itemView.findViewById(R.id.category_title_id);
            img_category_thumbnail = (ImageView) itemView.findViewById(R.id.category_image_id);
            cardView=(CardView) itemView.findViewById(R.id.cardview_id);
        }

    }
}
