package com.libo.kaifa.clonestyle;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/**
 * /**
 *
 * @Author libo
 * @create 2021/8/30 12:20 上午
 * @describe:  Cloneable  标准具有原型模式的copy 能力,
 *
 */
public  class WordDocument implements  Cloneable{
    private  String title="";
    private ArrayList<String> images;
    private ArrayList<String> text;
    public WordDocument() {
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        WordDocument document= (WordDocument) super.clone();
        document.title=this.title;//由于string final 修饰的特殊性，其也是深copy
        document.text=this.text; //潜copy 引用的同一实例地址
        document.images= (ArrayList<String>) this.images.clone();// 深copy 创建后，不会指向同一引用实例，保证了本部数据的安全性，
        return document;
    }
}
