package com.example.NetflixClient.models;

public class Categories {

    private Long id;
    private String category_name;

    public Categories(String category_name) {
        this.category_name = category_name;
    }

    public Categories() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
