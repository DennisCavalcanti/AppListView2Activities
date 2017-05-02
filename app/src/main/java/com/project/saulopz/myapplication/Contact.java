package com.project.saulopz.myapplication;

public class Contact {
    private int id;
    private String name;
    private String phone;

    public Contact() {
    }

    public Contact(int id, String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return name;
    }
}
