package com.shoestore.bean;

import java.sql.Date;

public class Product {
	private String name;
	private String image;
	private String description;
	private double price;
	private String datetime;
	private String id;
	
	public void setId(String id)
	{
		this.id = id;
	}
	public String getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getImage()
	{
		return image;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return description;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		
		return price;
	}
}
