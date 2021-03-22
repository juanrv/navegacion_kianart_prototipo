package com.example.esqueleto_kianart.entity;

public class Imagen {
    private int numeroMeGusta;
    private int imagen;
    private long idImagen;

    public Imagen(int numeroMeGusta, int imagen, long idImagen) {
        this.numeroMeGusta = numeroMeGusta;
        this.imagen = imagen;
        this.idImagen = idImagen;
    }

    public int getNumeroMeGusta() {
        return numeroMeGusta;
    }

    public void setNumeroMeGusta(int numeroMeGusta) {
        this.numeroMeGusta = numeroMeGusta;
    }

    public int getImagen() {
        return imagen;
    }

    public long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(long idImagen) {
        this.idImagen = idImagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
