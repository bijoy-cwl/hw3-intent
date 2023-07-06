package com.bijoydebnath.hw3;

public class News {
    private int id;
    private String title;
    private String description;
    private String date;
    private String img;

    public News(int id, String title, String description, String date, String img) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImg() {
        return img;
    }
}
