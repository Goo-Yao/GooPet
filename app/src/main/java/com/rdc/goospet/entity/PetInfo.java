package com.rdc.goospet.entity;

/**
 * Created by Goo on 2016-10-19.
 */

/**
 * 宠物信息配置
 */
public class PetInfo {
    private int petId;
    private boolean isSelected;//选中
    private int picId;//图片资源
    private String name;//名字
    private String description;//描述

    public PetInfo(int petId, String name, String description, int picId, boolean isSelected) {
        this.petId = petId;
        this.name = name;
        this.description = description;
        this.picId = picId;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}
