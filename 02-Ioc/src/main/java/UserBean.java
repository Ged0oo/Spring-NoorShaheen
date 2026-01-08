package com.demo;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String name;

    public UserBean(){}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public void displayInfo(){
        System.out.println("Hello From Bean => " + name);
    }
}
