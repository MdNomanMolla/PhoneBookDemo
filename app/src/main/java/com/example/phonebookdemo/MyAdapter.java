package com.example.phonebookdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    MyClick myClick;
    Context context;
    List<Model_Class> arrayList;


    public MyAdapter(Context context, List<Model_Class>arrayList,MyClick myClick) {
        this.context=context;
        this.arrayList=arrayList;
        this.myClick=myClick;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View view=  LayoutInflater.from(context).inflate(R.layout.sample,parent,false);
      final MyViewHolder myViewHolder=new MyViewHolder(view);
     view.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             myClick.OnMyClick(view,myViewHolder.getPosition());
             return true;
         }
     });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

       // holder.textView.setText(datalist.get(position).getCountryNames());
          holder.circleImageView.setImageResource(arrayList.get(position).getPhoto());
          holder.nameTextView.setText(arrayList.get(position).getName());
          holder.phoneTextView.setText(String.valueOf(arrayList.get(position).getPhone()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder  {
    CircleImageView circleImageView;
    TextView nameTextView;
    TextView phoneTextView;
    ImageView phoneImageView;
    ImageView smsImageView;

    public MyViewHolder(@NonNull View itemView)  {
        super(itemView);
       circleImageView=itemView.findViewById(R.id.circleImageViewId);
        nameTextView=itemView.findViewById(R.id.nameId);
        phoneTextView=itemView.findViewById(R.id.phoneId);
        phoneImageView=itemView.findViewById(R.id.phoneImageViewId);
        smsImageView=itemView.findViewById(R.id.smsImageViewId);


    }



}