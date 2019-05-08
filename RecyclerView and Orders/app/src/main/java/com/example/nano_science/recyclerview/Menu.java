package com.example.nano_science.recyclerview;

public class Menu {

    private int id;
    private String title, shortdesc;
    private double price;
    private int image;

    public Menu(int id, String title, String shortdesc, double price, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}

