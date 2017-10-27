package com.example.wxy.easy_treat;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MachineActivity extends AppCompatActivity {
    private DrawerLayout mydrawerLayout ;
    private List<Machine  > Machines=new ArrayList<>() ;
    SwipeRefreshLayout swipeRefresh;
    MachineApapter machineApapter ;
    public void setUI(){
        RecyclerView recyclerView =(RecyclerView ) findViewById(R.id.hospitalRecylerView);
        StaggeredGridLayoutManager LayoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL) ;
        recyclerView .setLayoutManager(LayoutManager );
        machineApapter= new  MachineApapter(Machines);
        recyclerView.setAdapter(machineApapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);
        input();
        setUI();
    }
    public void input(){
        String name1 = "CT";
        String time1="2017.10.28";
        String text1="青岛第一医院 放射科 剩余号数量：20";
        int image=R.drawable.header_back;
        Machine m1 =new Machine(name1 ,time1 ,text1  ,image) ;
        Machines .add(m1 ) ;
    }
}
