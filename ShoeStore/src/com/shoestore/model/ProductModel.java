package com.shoestore.model;

import java.util.ArrayList;

import com.shoestore.bean.Product;

public class ProductModel {
	public static ArrayList<Product> getAll()
	{
		ArrayList<Product> list = new ArrayList<Product>();
		Dbconnection db = new Dbconnection();
		list = db.getAllProduct();
		db.closeconnection();
		return list;
	}
}
