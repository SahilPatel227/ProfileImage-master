package com.example.admin.profileimage;

/**
 * Created by Admin on 8/21/2017.
 */

public class Friends {
    private String Name,Email;

    public Friends() {
    }

    public Friends(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


}
