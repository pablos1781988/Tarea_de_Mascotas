package com.ps.petfollowing;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ps.petfollowing.adapter.mascotas_adapter;
import com.ps.petfollowing.pojo.Mascotas;

import java.util.ArrayList;
import java.util.Collections;

//import static com.ps.petfollowing.MainActivity.mascotas;
import static com.ps.petfollowing.fragment.PerfilFragment.mascotas;
public class top5_mascotas extends AppCompatActivity {

    ArrayList<Mascotas> top5Mascotas;
    private RecyclerView rvmascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5_mascotas);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        rvmascotas=(RecyclerView) findViewById(R.id.rvmascotas1);
        LinearLayoutManager llm = new LinearLayoutManager(this );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvmascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaradaptador();



    }
    public void inicializaradaptador() {
        mascotas_adapter adapter =new mascotas_adapter(top5Mascotas, this);
        rvmascotas.setAdapter(adapter);

    }
    public void inicializarListaMascotas(){

    top5Mascotas= new ArrayList<>();
    Collections.sort(mascotas);
    for(int i=0;i<5;i++){
        top5Mascotas.add(mascotas.get(i));
    }
    }
}