package com.huatec.hiot_cloud.test.networktest;

import java.io.Serializable;

/**
 * 李四信息实体类
 */
public class People implements Serializable {
    private String id;
    private boolean graduated;
    private int height;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
