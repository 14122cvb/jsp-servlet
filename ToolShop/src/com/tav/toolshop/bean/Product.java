package com.tav.toolshop.bean;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private double price;
    
    private String description;
    private int trademark_id;
    private int category_id;
    
    private String user_username;
    private int hot;
    private Date update_time;
    
    
    private String photo;

    
//    public Product(String name,double price,String description,int trademark_id,int category_id,
//    		String user_username,int hot,Date update_time,String photo,String available,
//    		int warranties,String transport,String include_st) {
//        this.name=name;
//        this.price=price;
//        this.description=description;
//        this.trademark_id=trademark_id;
//        this.category_id=category_id;
//        this.user_username=user_username;
//        this.hot=hot;
//        this.update_time=update_time;
//        this.photo=photo;
//        this.available=available;
//        this.warranties=warranties;
//        this.transport=transport;
//        this.include_st=include_st;
//    }
    public void setId(int id)
    {
    	this.id=id;
    }
    public int getId()
    {
    	return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    
    public void setTrademark_id(int trademark_id) {
        this.trademark_id = trademark_id;
    }
    public int getTrademark_id() {
        return trademark_id;
    }
    
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public int getCategory_id() {
        return category_id;
    }
    
    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }
    public String getUser_username() {
        return user_username;
    }
    
    public void setHot(int hot) {
        this.hot = hot;
    }
    public int getHot() {
        return hot;
    }
    
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public Date getUpdate_time() {
        return update_time;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getPhoto() {
        return photo;
    }

    
    
    
}