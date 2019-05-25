package com.example.designer2.strucure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    private List<videoModel> videolist;
    private Context context;




    public RecyclerviewAdapter(Context context, List<videoModel> videolist) {

        this.context = context;
        this.videolist = videolist;




    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(context);
            view=  inflater.inflate(R.layout.row_item,viewGroup,false);

            return new ViewHolder(view);






    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final videoModel model = videolist.get(i);

        viewHolder.title.setText(videolist.get(i).getTitle());
        viewHolder.time.setText(videolist.get(i).getDuration());
        viewHolder.artist.setText(videolist.get(i).getViews());
        Glide.with(context).load(videolist.get(i).getFeaturedimg()).into(viewHolder.thumbnail);








        // Picasso.get().load(strCategoryThum).placeholder(R.drawable.ic_circle).into(viewHolder.categoryThumb);

        viewHolder.contaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity.class);

                intent.putExtra("url",videolist.get(i).getVideolink());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return videolist.size();
    }





    public static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout contaner;
        ImageView thumbnail;
        TextView title;
        TextView time;
        TextView artist;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contaner = itemView.findViewById(R.id.conainerss);
            thumbnail = itemView.findViewById(R.id.thumbnail_id);
            title = itemView.findViewById(R.id.titletxt);
            time =  itemView.findViewById(R.id.date_id);
            artist = itemView.findViewById(R.id.author_name);
        }
    }
}
