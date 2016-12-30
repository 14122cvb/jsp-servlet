package com.tav.toolshop.bean;

public class Category {
	
    private int id;
    private String name;
    private int order_sort;
    
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
    
    public void setOrder_sort(int order_sort) {
        this.order_sort = order_sort;
    }
    public int getOrder_sort() {
        return order_sort;
    }

}
