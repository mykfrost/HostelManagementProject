package com.example.hostelmanagement;

public class TitleModel {
    public String getTitle_name() {
        return Title_name;
    }

    public void setTitle_name(String title_name) {
        Title_name = title_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public TitleModel(String title_name, int imgid) {
        Title_name = title_name;
        this.imgid = imgid;
    }

    private String Title_name;
    private int imgid;
}
