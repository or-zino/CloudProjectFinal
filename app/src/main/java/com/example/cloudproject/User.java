package com.example.cloudproject;

public class User {

    public String fullName, email, phone, address, instegram, imageName;

    public User(){

    }


    public User(String fullName, String email, String phone, String address, String instergram){
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.instegram = instergram;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
