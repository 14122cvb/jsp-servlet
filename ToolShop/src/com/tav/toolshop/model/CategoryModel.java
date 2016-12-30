package com.tav.toolshop.model;

import java.util.ArrayList;
import java.util.Date;

import com.tav.toolshop.bean.Category;
import com.tav.toolshop.bean.Product;
import com.tav.toolshop.model.dao.DbConnection;

public class CategoryModel {
	
	public static int addNewCategory(Category ctg)
	{
		DbConnection db=new DbConnection();
		String fields="name, order_sort";
		String values="'"+ctg.getName()+"',"+ctg.getOrder_sort();
		return db.insertData("category", fields, values);
	}
	public static Category getCategoryById(int id)
	{
		Category ctg=null;
		DbConnection db=new DbConnection();
		String fields="id, name, order_sort";
		String[] field=new String[3];
		field[0]="id";
		field[1]="name";
		field[2]="order_sort";
		Object[][] sl=db.selectDataWhere(fields, "category", field, "id="+id);
		if(sl.length!=0)
		{
			try
			{
				ctg=new Category();
				ctg.setId(id);
				ctg.setName(sl[0][1].toString());
				ctg.setOrder_sort(Integer.parseInt(sl[0][2].toString()));
			}
			catch(Exception ex){}
		}
		return ctg;
	}
	
	public static ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> list=new ArrayList<Category>();		
		DbConnection db=new DbConnection();
		String fields="id, name, order_sort";
		String[] field=new String[3];
		field[0]="id";
		field[1]="name";
		field[2]="order_sort";
		Object[][] sl=db.selectDataOrder(fields,"category", field, "order_sort");
		for(int i=0;i<sl.length;i++)
		{
			try
			{
			Category ct=new Category();
			ct.setId(Integer.parseInt(sl[i][0]+""));
			ct.setName(sl[i][1]+"");
			ct.setOrder_sort(Integer.parseInt(sl[i][2]+""));
			list.add(ct);
			}
			catch(NumberFormatException ne){}
		}
		return list;
	}
	public static int deleteCategory(int id)
	{
		DbConnection db=new DbConnection();
		return db.deleteData("category", " id="+id);
	}
	public static int editCategory(Category ctg)
	{
		DbConnection db=new DbConnection();
		String values=" name = '"+ctg.getName()+"', order_sort = "+ctg.getOrder_sort();
		return db.editData("category", values, "id = "+ctg.getId());
	}

}
