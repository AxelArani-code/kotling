package com.example.datefire.model;

import java.io.Serializable;

public class PizzaModel implements Serializable {
    private String item_id;
    private String calorias, presio, like, tamaño, titulo ,img_Pizza, descrp;

    public PizzaModel() {
    }

    public PizzaModel(String item_id, String calorias, String presio, String like, String tamaño, String titulo, String img_Pizza, String descrp) {
        this.item_id = item_id;
        this.calorias = calorias;
        this.presio = presio;
        this.like = like;
        this.tamaño = tamaño;
        this.titulo = titulo;
        this.img_Pizza = img_Pizza;
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

    public String getImg_Pizza() {
        return img_Pizza;
    }

    public void setImg_Pizza(String img_Pizza) {
        this.img_Pizza = img_Pizza;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }
}
