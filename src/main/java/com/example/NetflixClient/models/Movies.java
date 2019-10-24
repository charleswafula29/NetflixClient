package com.example.NetflixClient.models;

public class Movies {

    private Long id;
    private String name;
    private String type;
    private String yearReleased;

    public Movies() {
    }

    public Movies(String name, String type, String yearReleased) {
        this.name = name;
        this.type = type;
        this.yearReleased = yearReleased;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year_released='" + yearReleased + '\'' +
                '}';
    }
}
