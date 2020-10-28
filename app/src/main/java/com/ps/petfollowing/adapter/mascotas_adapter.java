package com.ps.petfollowing.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ps.petfollowing.pojo.Mascotas;
import com.ps.petfollowing.R;

import java.util.ArrayList;
import java.util.List;

public class mascotas_adapter extends RecyclerView.Adapter<mascotas_adapter.Mascotas_view_holder>{

    ArrayList<Mascotas> ListaMascotas;
    Activity activity;
    @NonNull
    @Override
    public Mascotas_view_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_mascotas,viewGroup, false);
        return new Mascotas_view_holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Mascotas_view_holder mascotas_view_holder, int i) {

        final Mascotas mascotas = ListaMascotas.get(i);
        mascotas_view_holder.imgfoto.setImageResource(mascotas.getFoto());
        mascotas_view_holder.tvnombre.setText("Nombre: "+mascotas.getNombre());
        mascotas_view_holder.tvnombredueño.setText("Dueño: "+mascotas.getNombreDueño());
        mascotas_view_holder.tvedad.setText("Edad: "+(Integer.toString(mascotas.getEdad())));
        mascotas_view_holder.tvdescripcion.setText(mascotas.getDescripcion());
        mascotas_view_holder.tvlikes.setText(Integer.toString(mascotas.getLikes()));

        mascotas_view_holder.imghueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascotas.setLikes(mascotas.getLikes()+1);
                mascotas_view_holder.tvlikes.setText(Integer.toString(mascotas.getLikes()));
                mascotas_view_holder.imghueso1.setBackgroundColor(Color.BLUE);
            }
        });


    }

    @Override
    public int getItemCount() {

        return ListaMascotas.size();
    }


    @Override
    public void onBindViewHolder(@NonNull Mascotas_view_holder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public static class Mascotas_view_holder extends RecyclerView.ViewHolder{
    private ImageView   imgfoto;
    private ImageButton imghueso;
    private ImageButton imghueso1;
    private TextView    tvnombre;
    private TextView    tvnombredueño;
    private TextView    tvedad;
    private TextView    tvdescripcion;
    private TextView    tvlikes;

    public Mascotas_view_holder(@NonNull View itemView) {
        super(itemView);

        imgfoto=(ImageView)itemView.findViewById(R.id.imgFoto);
        imghueso=(ImageButton) itemView.findViewById(R.id.imgbuttonhueso);
        imghueso1=(ImageButton) itemView.findViewById(R.id.imgbuttonhuesodos);
        tvnombre=(TextView) itemView.findViewById(R.id.tvNombre);
        tvnombredueño=(TextView) itemView.findViewById(R.id.tvNombreDueño);
        tvedad=(TextView)  itemView.findViewById(R.id.tvedad);
        tvdescripcion=(TextView) itemView.findViewById(R.id.tvdescripcion);
        tvlikes=(TextView) itemView.findViewById(R.id.tvlikes);
    }

}


public mascotas_adapter(ArrayList<Mascotas> mascotas,Activity activity){

    this.ListaMascotas=mascotas;
    this.activity=activity;

}




}
