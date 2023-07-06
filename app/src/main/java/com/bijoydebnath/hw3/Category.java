package com.bijoydebnath.hw3;

import androidx.annotation.NonNull;

public class Category {
    private int id;
    private String title;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
