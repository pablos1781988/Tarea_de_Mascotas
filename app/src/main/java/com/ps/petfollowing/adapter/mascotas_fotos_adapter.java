package com.ps.petfollowing.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ps.petfollowing.R;
import com.ps.petfollowing.pojo.Mascotas;
import com.ps.petfollowing.pojo.Mascotas_fotos;

import java.util.ArrayList;

public class mascotas_fotos_adapter extends RecyclerView.Adapter<mascotas_fotos_adapter.mascotas_fotos_view_holder> {

    ArrayList<Mascotas_fotos> ListaMascotasfotos;
    Activity activity;
    public mascotas_fotos_adapter(ArrayList<Mascotas_fotos> ListaMascotasFotos){

        this.ListaMascotasfotos=ListaMascotasFotos;

    }
    @NonNull
    @Override
    //Infla el layout (CArd view) y lo pasa al view holder para que obtenga los views
    public mascotas_fotos_view_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_imagen, viewGroup,false);
        return new mascotas_fotos_view_holder(v);
    }

    @Override
    //asocia los elementos de la lista a los views (setea valores)
    public void onBindViewHolder(@NonNull final mascotas_fotos_view_holder Mascotas_fotos_View_Holder, int i) {

        final Mascotas_fotos fotomascota=ListaMascotasfotos.get(i);

        Mascotas_fotos_View_Holder.fotomascota.setImageResource(fotomascota.getFoto());
        Mascotas_fotos_View_Holder.Likes2.setText(Integer.toString(fotomascota.getLikes()));

    }

    @Override
    //Devuelve cantidad de elementos
    public int getItemCount() {
        return ListaMascotasfotos.size();
    }


    public static class mascotas_fotos_view_holder extends RecyclerView.ViewHolder{
        ImageView fotomascota;
        ImageView hueso2;
        TextView Likes2;

        public mascotas_fotos_view_holder(@NonNull View itemView) {
            super(itemView);
            fotomascota=(ImageView) itemView.findViewById(R.id.imgmascota);
            hueso2=(ImageView) itemView.findViewById(R.id.huesos);
            Likes2 = (TextView) itemView.findViewById(R.id.tvlikesperfil);

        }
    }
}
