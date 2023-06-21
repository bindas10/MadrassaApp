package com.example.myapplication;

import static com.example.myapplication.R.drawable.ic_launcher_foreground;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.viewholder> {
    List<Student_profile>   stdlist;
    Context context;
    public myRecyclerViewAdapter(List<Student_profile> list,Context cont)
    {
        this.stdlist=list;
        this.context=cont;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.userview,parent,false);



        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        String id=stdlist.get(position).getId();
        String name=stdlist.get(position).getName();
        String age=stdlist.get(position).getAge();
        holder.id.setText(id);
        holder.name.setText(name);
        holder.age.setText(age);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Show_Daily_Task.class);
                intent.putExtra("id",id);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return stdlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id,name,age;
        ImageView img;
        public viewholder(View itemView)
        {

            super(itemView);
            id=(TextView)itemView.findViewById(R.id.ID);
            name=(TextView) itemView.findViewById(R.id.name);
            age=(TextView) itemView.findViewById(R.id.age);
            img=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
