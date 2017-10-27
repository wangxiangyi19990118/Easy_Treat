package com.example.wxy.easy_treat;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
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
 * Created by wxy on 2017/10/25.
 */

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> implements View.OnClickListener
{
    private List<Hospital >hospitalList =new ArrayList<>() ;
    public HospitalAdapter (List <Hospital> hospitals ){hospitalList =hospitals ;}
    public HospitalAdapter .OnItemClickListener mOnItemClickListener = null;
    @Override
    public HospitalAdapter .ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater .from(parent .getContext() ).inflate(R.layout.hospital_recyclerview,parent ,false) ;
        ViewHolder holder=new ViewHolder(view ) ;
        holder .context=parent .getContext() ;
        view .setOnClickListener(this) ;
        return holder ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hospital hospital =hospitalList .get(position ) ;
        holder .itemView .setTag(position ) ;
        holder .hospitalName.setText(hospital .getHospitalName());
        holder .hospitalAdress.setText(hospital .getHospitalAdress());
        Glide .with(holder .context) .load(hospital .getHospitalImageId() ).asBitmap() .error(android.R.drawable.dark_header).into(holder .hospitalImageId) ;

    }

    @Override
    public int getItemCount() {
        return hospitalList .size();
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
        TextView hospitalName;
        TextView hospitalAdress;
        ImageView hospitalImageId;
        Context context ;
        View hospitalView;
        public ViewHolder(View view) {
            super(view);
            hospitalView =view ;
            hospitalImageId= (ImageView) view.findViewById(R.id.dishesimage);
            hospitalName =(TextView )view.findViewById(R.id.DishName);
            hospitalAdress =(TextView )view.findViewById(R.id.DishPrice);
            hospitalImageId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(hospitalView .getContext(),MachineActivity .class );
                    hospitalView .getContext() .startActivity(intent);
                }
            });
        }
    }
}
