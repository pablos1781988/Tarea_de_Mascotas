package com.ps.petfollowing;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.ps.petfollowing.adapter.page_adapter;
import com.ps.petfollowing.fragment.Main_Fragment;
import com.ps.petfollowing.fragment.PerfilFragment;
import com.ps.petfollowing.pojo.Mascotas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Mascotas> mascotas;
    private RecyclerView rvmascotas;
    Activity activity=this;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);

        setUpViewPAger();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mabout:
                Intent intent=new Intent(this,  About.class);
                this.startActivity(intent);
                break;
            case R.id.mcontacto:
                Intent intent1=new Intent( this, Contacto.class);
                this.startActivity(intent1);

                break;
        }

        return super.onOptionsItemSelected(item);
    }


public void top5(View view){

        Intent intent=new Intent(this.activity,top5_mascotas.class);
        this.activity.startActivity(intent);
}
private ArrayList<Fragment> agregarfragment() {
        ArrayList<Fragment> fragments=new ArrayList<>();

        fragments.add(new PerfilFragment());
        fragments.add(new Main_Fragment());
        return fragments;
    }
    public void setUpViewPAger(){
        viewPager.setAdapter(new page_adapter((getSupportFragmentManager()),agregarfragment()));
        tabLayout.setupWithViewPager(viewPager);

      // tabLayout.getTabAt(0).setIcon(R.drawable.ic_group);
        //tabLayout.getTabAt(1).setIcon(R.drawable.ic_person_outline);

    }


}
