package com.example.myapplication;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DailyTaskRecycleAdapter extends RecyclerView.Adapter<DailyTaskRecycleAdapter.viewholder> {
    List<Task_Details> Tlist;
    List<Student_profile>stdlist;
    public DailyTaskRecycleAdapter(List<Task_Details> list,List<Student_profile>stdlist) {
        this.Tlist=list;
        this.stdlist=stdlist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.task_details,parent,false);



        return new DailyTaskRecycleAdapter.viewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.id.setText((String)Tlist.get(position).getId());
        holder.date.setText((String)Tlist.get(position).getDate());
        holder.name.setText((String)Tlist.get(position).getName());
        holder.range.setText("verse "+(String)Tlist.get(position).getRange());
        holder.para.setText((String)Tlist.get(position).getLast_para());
        holder.manzil.setText((String)Tlist.get(position).getManzil());
        holder.UName.setText((String)stdlist.get(0).getName());
        holder.clas.setText((String)stdlist.get(0).getStudent_class());
        holder.age.setText((String)stdlist.get(0).getAge());

    }

    @Override
    public int getItemCount() {
        return Tlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id,date,name,range,para,manzil;
        TextView UName,clas,age;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.showID);
            date=(TextView)itemView.findViewById(R.id.show_date);
            name=(TextView)itemView.findViewById(R.id.showName);
            range=(TextView)itemView.findViewById(R.id.show_range);
            para=(TextView)itemView.findViewById(R.id.show_paranumber);
            manzil=(TextView)itemView.findViewById(R.id.show_manzil);
            UName=(TextView)itemView.findViewById(R.id.show_NAME_detail);
            clas=(TextView)itemView.findViewById(R.id.show_class_detail);
            age=(TextView)itemView.findViewById(R.id.show_age_detail);
        }
    }
}
