package com.example.nano_science.menucrud;

public class FoodMenu {

    private int menuid;
    private String foodname, foodtype, recipe;
    private double price;

    public FoodMenu(int menuid, String foodname, String foodtype, String recipe, double price) {
        this.menuid = menuid;
        this.foodname = foodname;
        this.foodtype = foodtype;
        this.recipe = recipe;
        this.price = price;
    }

    public int getMenuid() {
        return menuid;
    }

    public String getFoodname() {
        return foodname;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public String getRecipe() {
        return recipe;
    }

    public double getPrice() {
        return price;
    }
}

