package com.ps.petfollowing.pojo;

public class Mascotas implements Comparable<Mascotas>{

private String Nombre;
private String NombreDueño;
private  String Descripcion;
private int edad;
private int foto;
private int likes=0;


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Mascotas(String nombre, String nombreDueño, String descripcion, int edad, int foto){
    this.Nombre=nombre;
    this.NombreDueño=nombreDueño;
    this.Descripcion=descripcion;
    this.edad=edad;
    this.foto=foto;



}
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombreDueño() {
        return NombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        NombreDueño = nombreDueño;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int compareTo(Mascotas o) {
        if(o.getLikes()>likes){
            return 1;
        }else if(o.getLikes()==likes){
            return 0;
        }else{
            return -1;
        }

    }
}
