package com.example.wxy.easy_treat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxy on 2017/10/26.
 */

public class MachineApapter extends RecyclerView.Adapter<MachineApapter.ViewHolder> implements View.OnClickListener
{
    private List<Machine > machineList =new ArrayList<>() ;
    public MachineApapter (List <Machine > machines ){machineList = machines  ;}
    public MachineApapter .OnItemClickListener mOnItemClickListener = null;
    @Override
    public MachineApapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent .getContext() ).inflate(R.layout.machine_recylerview,parent ,false) ;
        MachineApapter.ViewHolder holder=new MachineApapter.ViewHolder(view ) ;
        holder .context=parent .getContext() ;
        view .setOnClickListener(this) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(MachineApapter.ViewHolder holder, int position) {
        Machine machine =machineList .get(position ) ;
        holder .itemView .setTag(position ) ;
        holder .machineName.setText(machine .getMachineName());
        holder .machineTime.setText(machine.getMachineTime());
        holder .machineText .setText(machine .getMachineText() ) ;
        Glide.with(holder .context) .load(machine.getMachineImage() ).asBitmap() .error(android.R.drawable.dark_header).into(holder.machineImage) ;

    }

    @Override
    public int getItemCount() {
        return machineList .size();
    }

    @Override
    public void onClick(View v) {
        if (this.mOnItemClickListener != null) {
            this.mOnItemClickListener.onItemClick(v,(int)v.getTag() );
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView machineName;
        TextView machineTime;
        TextView machineText;
        ImageView machineImage;
        Context context ;
        View machineView;
        public ViewHolder(View view) {
            super(view);
            machineView  =view ;
            machineImage= (ImageView) view.findViewById(R.id.dishesimage1);
            machineName =(TextView )view.findViewById(R.id.DishName1);
            machineText =(TextView)view .findViewById(R.id.DishPrice2) ;
            machineTime =(TextView )view.findViewById(R.id.DishPrice1);
        }
    }
}
