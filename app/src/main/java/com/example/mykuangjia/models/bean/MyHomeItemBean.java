package com.example.mykuangjia.models.bean;

public class MyHomeItemBean {
    private int image;
    private String title;

    public MyHomeItemBean(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MyHomeItemBean{" +
                "image=" + image +
                ", title='" + title + '\'' +
                '}';
    }
}
