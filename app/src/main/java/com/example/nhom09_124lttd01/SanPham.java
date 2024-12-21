package com.example.nhom09_124lttd01;

import java.io.Serializable;

public class SanPham {
    private int resourceID;
    private String tittle, price;

    public SanPham(int resourceID, String tittle, String price) {
        this.resourceID = resourceID;
        this.tittle = tittle;
        this.price = price;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}