package com.legend.bannerviewdemo.bean;

/**
 * @author Legend
 * @data by on 2018/2/9.
 * @description
 */

public class ItemBean {

    private String item;

    public ItemBean(String itemName) {
        this.item = itemName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
