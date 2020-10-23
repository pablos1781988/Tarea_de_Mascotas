package com.ps.petfollowing;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Mascotas> mascotas;
    private RecyclerView rvmascotas;
    Activity activity=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        rvmascotas=(RecyclerView) findViewById(R.id.rvmascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvmascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaradaptador();







    }


    public void inicializaradaptador() {
        mascotas_adapter adapter =new mascotas_adapter(mascotas, this);
        rvmascotas.setAdapter(adapter);


    }
    public void inicializarListaMascotas(){
    mascotas=new ArrayList<Mascotas>();

    mascotas.add(new Mascotas("Junior","Pablo","Perro Raza Callejero, muy astuto",7,R.drawable.perro));
    mascotas.add(new Mascotas("Loretini","Lorena", "bastante rompepelotas",3,R.drawable.loro));
    mascotas.add(new Mascotas("cuicui","Emilia","Caga por todos lados,muy oloroso",2,R.drawable.cui));
    mascotas.add(new Mascotas("Gatuvin","Felipe","Muy independiente",8,R.drawable.gato));
    mascotas.add(new Mascotas("Gatoman","Ana","inteligente de color indefinido",5,R.drawable.gatoextra_o));
    mascotas.add(new Mascotas("Luisito","Emilia","Caga por todos lados,muy oloroso",2,R.drawable.conejo));
    mascotas.add(new Mascotas("GaViula","Felipe","Muy independiente",8,R.drawable.ratonmamadera));
    mascotas.add(new Mascotas("Gonada","Ana","inteligente de color indefinido",5,R.drawable.gatoperro));
    }
public void top5(View view){

        Intent intent=new Intent(this.activity,top5_mascotas.class);
        this.activity.startActivity(intent);
}

}
