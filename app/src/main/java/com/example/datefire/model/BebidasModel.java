package com.example.datefire.model;

import java.io.Serializable;

public class BebidasModel implements Serializable {
    private String item_id;
    private String img_resources;
    private String name;
    private String presio;
    private String descrp;
    private String grado;
    private  String Ml;
    private String like;
//Simpre tiene que ir asino no te toma la base de datos de

    public BebidasModel() {
    }

    public BebidasModel(String item_id, String img_resources, String name, String descrp, String grado, String ml, String like, String presio) {
        this.item_id = item_id;
        this.img_resources = img_resources;
        this.name = name;
        this.descrp = descrp;
        this.grado = grado;
        this.presio = presio;
        Ml = ml;
        this.like = like;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getImg_resources() {
        return img_resources;
    }

    public void setImg_resources(String img_resources) {
        this.img_resources = img_resources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getMl() {
        return Ml;
    }

    public void setMl(String ml) {
        Ml = ml;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getPresio() {
        return presio;
    }

    public void setPresio(String presio) {
        this.presio = presio;
    }
}
