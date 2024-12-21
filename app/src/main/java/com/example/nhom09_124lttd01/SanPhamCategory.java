package com.example.nhom09_124lttd01;

import java.util.List;

public class SanPhamCategory {
    private String nameCategory;



    private List<SanPham> list;

    public SanPhamCategory(String nameCategory, List<SanPham> list) {
        this.nameCategory = nameCategory;
        this.list = list;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<SanPham> getList() {
        return list;
    }

    public void setList(List<SanPham> list) {
        this.list = list;
    }
}
