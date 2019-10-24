package com.example.NetflixClient.models;

public class Users {

    private Long id;
    private String name;
    private Integer nationalID;

    public Users(String name, Integer nationalID) {
        this.name = name;
        this.nationalID = nationalID;
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

    public Integer getNationalID() {
        return nationalID;
    }

    public void setNationalID(Integer nationalID) {
        this.nationalID = nationalID;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationalID=" + nationalID +
                '}';
    }
}
