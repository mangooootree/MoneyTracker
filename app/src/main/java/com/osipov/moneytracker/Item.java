package com.osipov.moneytracker;

public class Item {
    private final String title;
    private final int price;
    private String comment;

    public Item(String name, int price) {
        this.title = name;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }
}
