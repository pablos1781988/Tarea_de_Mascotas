package com.ps.petfollowing.pojo;

import android.support.v7.widget.RecyclerView;

public class Mascotas_fotos {
    private int foto;
    private int likes;
    private String nombremascota;

    public Mascotas_fotos(int foto, int likes, String nombremascota) {

        this.foto = foto;
        this.likes = likes;
        this.nombremascota = nombremascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }
}
