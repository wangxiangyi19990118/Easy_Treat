package com.example.wxy.easy_treat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mydrawerLayout ;
    private List <Hospital > Hospitals=new ArrayList<>() ;
    SwipeRefreshLayout swipeRefresh;
    HospitalAdapter hospitalAdapter;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu .toolbarmain,menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item .getItemId()){
            case android.R.id.home :
                mydrawerLayout .openDrawer(GravityCompat .START) ;
                break;
        }
        return true;
    }
    public void setUI(){
        RecyclerView recyclerView =(RecyclerView ) findViewById(R.id.recyclerview);
        StaggeredGridLayoutManager LayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) ;
        recyclerView .setLayoutManager(LayoutManager );
        hospitalAdapter = new HospitalAdapter(Hospitals);
        recyclerView.setAdapter(hospitalAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbarMain=(Toolbar ) findViewById(R.id.toolbarMain) ;
        setSupportActionBar(toolbarMain);
        mydrawerLayout =(DrawerLayout )findViewById(R.id.user_drawer_layout ) ;
        NavigationView navigationView=(NavigationView)findViewById(R.id.user_inf) ;
        navigationView.setItemIconTintList(null);
        ActionBar actionBar =getSupportActionBar() ;
        input();
        setUI();
        if(actionBar !=null){
            actionBar .setDisplayHomeAsUpEnabled(true);
            actionBar .setHomeAsUpIndicator(R.mipmap.ic_action_menu) ;
        }
        navigationView.setCheckedItem(R.id.user_inf);
        navigationView .setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mydrawerLayout .closeDrawers();
                return true;
            }
        });
    }
    public void input(){
        String name1="青岛市市立医院";
        String adress1="松岭路";
        int id1=1;
        int image1=R.drawable .left1;
        String name2="青岛市九龙医院";
        String adress2="松岭路";
        int id2=1;
        int image2=R.drawable .left1;
        String name3="青岛市中心医院";
        String adress3="松岭路";
        int id3=1;
        int image3=R.drawable .left1;
        String name4="青岛市城阳医院";
        String adress4="松岭路";
        int id4=1;
        int image4=R.drawable .left1;
        Hospital h1=new Hospital(name1,adress1 ,image1,id1 ) ;
        Hospital h2=new Hospital(name2,adress2 ,image2,id2 ) ;
        Hospital h3=new Hospital(name3,adress3 ,image3,id3) ;
        Hospital h4=new Hospital(name4,adress4 ,image4,id4 ) ;
        Hospitals .add(h1) ;
        Hospitals .add(h2) ;
        Hospitals .add(h3) ;
        Hospitals .add(h4) ;
        Hospitals .add(h1) ;
        Hospitals .add(h2) ;
        Hospitals .add(h3) ;
        Hospitals .add(h4) ;
    }
}
