package com.legend.bannerviewdemo.bean;

/**
 * @author Legend
 * @data by on 2018/2/8.
 * @description
 */

public class TestBean {

    private int imageId;
    private String title;

    public TestBean(String title,int imageId) {
        this.title = title;
        this.imageId = imageId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
