package com.example.datefire.model;

public class ProductsModel {
    private String item_id;
    private String image_list;
    private String name;
    private long price;
//Simpre tiene que ir asino no te toma la base de datos de


    public ProductsModel() {

    }
    public ProductsModel(String name, long price, String item_id, String image_list) {
        this.name = name;
        this.price = price;
        this.item_id = item_id;
        this.image_list  = image_list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getImage_list() {
        return image_list;
    }

    public void setImage_list(String image_list) {
        this.image_list = image_list;
    }
}
