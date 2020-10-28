package com.ps.petfollowing.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.ps.petfollowing.R;
import com.ps.petfollowing.adapter.mascotas_adapter;
import com.ps.petfollowing.pojo.Mascotas;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {


    public static ArrayList<Mascotas> mascotas;
    private RecyclerView rvmascotas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View v= inflater.inflate(R.layout.fragment_perfil, container, false);

        
        rvmascotas=(RecyclerView) v.findViewById(R.id.rvmascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvmascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaradaptador();

        return  v;

    }

    public void inicializaradaptador() {
        mascotas_adapter adapter =new mascotas_adapter(mascotas, getActivity());
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
}