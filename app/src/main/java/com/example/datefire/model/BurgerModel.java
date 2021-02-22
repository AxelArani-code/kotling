package com.example.datefire.model;

import java.io.Serializable;

public class BurgerModel implements Serializable {
    private String item_id;
    private String calorias, presio, like, tamaño, titulo ,img_Hambur, descrp;

    public BurgerModel() {
    }

    public BurgerModel(String item_id, String calorias, String presio, String like, String tamaño, String titulo, String img_Hambur, String descrp) {
        this.item_id = item_id;
        this.calorias = calorias;
        this.presio = presio;
        this.like = like;
        this.tamaño = tamaño;
        this.titulo = titulo;
        this.img_Hambur = img_Hambur;
        this.descrp = descrp;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getPresio() {
        return presio;
    }

    public void setPresio(String presio) {
        this.presio = presio;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg_Hambur() {
        return img_Hambur;
    }

    public void setImg_Hambur(String img_Hambur) {
        this.img_Hambur = img_Hambur;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }
}
