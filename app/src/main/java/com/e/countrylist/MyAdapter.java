package com.e.countrylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {
    Context context;
    LayoutInflater inflater;
    List<Model> list;
    MainActivity activity;

    public MyAdapter(Context context, List<Model> list,MainActivity activity) {
        this.context = context;
        this.list = list;
        this.activity=activity;
        inflater=LayoutInflater.from(context);
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
                TextView textView;
                TextView textView2;
                ImageView imageView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.country);
            textView2=itemView.findViewById(R.id.capital);
            imageView=itemView.findViewById(R.id.flag);
        }
    }
    @NonNull
    @Override
    public MyAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.list,parent,false);
        MyAdapter.MyViewholder holder=new MyAdapter.MyViewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewholder holder, int position) {
            holder.textView.setText(list.get(position).getName());
            holder.textView2.setText(list.get(position).capital);
        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground)
                .load(list.get(position).getFlag(),holder.imageView) ;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
