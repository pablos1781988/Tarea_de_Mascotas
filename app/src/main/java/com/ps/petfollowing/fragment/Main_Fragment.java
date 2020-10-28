package com.ps.petfollowing.fragment;

import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.petfollowing.R;
import com.ps.petfollowing.adapter.mascotas_adapter;
import com.ps.petfollowing.adapter.mascotas_fotos_adapter;
import com.ps.petfollowing.pojo.Mascotas_fotos;

import java.util.ArrayList;


public class Main_Fragment extends Fragment {


public static ArrayList<Mascotas_fotos> fotos_mascotas;
private RecyclerView rvfotosMAscotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_main_, container, false);

        rvfotosMAscotas=(RecyclerView) v.findViewById(R.id.rvmascotasfotos);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity() );
        //llm.setOrientation(LinearLayoutManager.VERTICAL);


        GridLayoutManager llm= new GridLayoutManager(getActivity(), 3);
        rvfotosMAscotas.setLayoutManager(llm);
        inicializarfotosmascotas();
        inicializaradaptador();


return v;

    }

    public void inicializaradaptador() {
        mascotas_fotos_adapter adapter =new  mascotas_fotos_adapter (fotos_mascotas);
        rvfotosMAscotas.setAdapter(adapter);


    }
    public void inicializarfotosmascotas(){
        fotos_mascotas=new ArrayList<Mascotas_fotos>();

        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton1,8,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.rat2,50,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton3,20,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton4,5,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton5,3,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton6,15,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton7,2,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton8,0,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton9,58,"Ratinmbu"));
        fotos_mascotas.add(new Mascotas_fotos(R.drawable.raton10,35,"Ratinmbu"));


    }
}