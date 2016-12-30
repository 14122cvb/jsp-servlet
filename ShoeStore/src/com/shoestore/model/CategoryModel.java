package com.shoestore.model;

import java.util.ArrayList;

import com.shoestore.bean.Category;

public class CategoryModel {
	public static ArrayList<Category> getAll()
	{
		ArrayList<Category> list = new ArrayList<Category>();
		Dbconnection db = new Dbconnection();
		list = db.getAllCategory();
		db.closeconnection();
		return list;
	}
}
