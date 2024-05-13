package com.example.demo3;

public abstract class Food implements Comparable<Food> {
    private String foodImg="";
    private String name;
    private Double price;
    abstract public String getName();
    abstract public  double getPrice();
    abstract public void setName(String name);
    abstract public void setPrice( double price);
    Food(){

    }
    Food(String name ,Double price , String foodImg){
        this.name=name;
        this.price=price;
        this.foodImg=foodImg;
    }
    public void setFoodImg(String foodImg){
        this.foodImg=foodImg;
    }
    public String getFoodImg(){
        return foodImg;
    }
    // in every clsss we need no arg constructor and constructor to set name and price
    // every class should override compareTo method according to PRICE

}
