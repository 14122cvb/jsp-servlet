package com.tav.toolshop.model;

import java.util.ArrayList;
import java.util.Date;

import com.tav.toolshop.bean.Product;
import com.tav.toolshop.model.dao.DbConnection;
import com.tav.toolshop.util.BaseFunction;

public class ProductModel {
	
	public static int addNewProcduct(Product prd)
	{
		DbConnection db=new DbConnection();
		Date now=new Date();
		String fields="name, price, description, trademark_id, category_id, user_username, hot, update_time, photo";
		String values="'"+prd.getName()+"',"+prd.getPrice()+", '"+prd.getDescription()+"', "+prd.getTrademark_id()+", "
				+prd.getCategory_id()+", '"+prd.getUser_username()+"', "+prd.getHot()+", '"+BaseFunction.getTimeFormat(now)+"', '"+prd.getPhoto()+"'";
		return db.insertData("product", fields, values);
	}
	public static Product getHotProduct()
	{
		Product prd=null;
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		Object[][] sl=db.selectDataWhereOrder(fields, "product", field, "hot=1", " update_time");
		prd=convertToProduct(sl);
		return prd;
	}
	public static Product getProductCheap()
	{
		Product prd=null;
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		Object[][] sl=db.selectDataOrder(fields, "product", field, "price");
		prd=convertToProduct(sl);
		return prd;
	}
	
	public static String[] getFieldArr()
	{
		String[] field=new String[10];
		field[0]="id";
		field[1]="name";
		field[2]="price";
		field[3]="description";
		field[4]="trademark_id";
		field[5]="category_id";
		field[6]="user_username";
		field[7]="hot";
		field[8]="update_time";
		field[9]="photo";
		return field;
	}
	public static String getFields()
	{
		return "id, name, price, description, trademark_id, category_id, user_username, hot, update_time, photo";
		
	}
	public static ArrayList<Product> convertToListProduct(ArrayList<Object[]> sl_l)
	{
		ArrayList<Product> list=new ArrayList<Product>();
		for(int i=0;i<sl_l.size();i++)
		{
			Object[] sl=sl_l.get(i);
			Product prd=new Product();
			prd.setId(Integer.parseInt(sl[0].toString()));
			prd.setName(sl[1].toString());
			prd.setPrice(Double.parseDouble(sl[2].toString()));
			prd.setDescription(sl[3].toString());
			prd.setTrademark_id(Integer.parseInt(sl[4].toString()));
			prd.setCategory_id(Integer.parseInt(sl[5].toString()));
			prd.setUser_username(sl[6].toString());
			prd.setHot(Integer.parseInt(sl[7].toString()));
			prd.setPhoto(sl[9].toString());
			//prd.setUpdate_time(new Date(sl[i][8].toString()));
			list.add(prd);
		}
		return list;
	}
	public static Product convertToProduct(Object[][] sl)
	{
		Product prd=null;
		if(sl.length!=0)
		{
			try
			{
				prd=new Product();
				prd.setId(Integer.parseInt(sl[0][0].toString()));
				prd.setName(sl[0][1].toString());
				prd.setPrice(Double.parseDouble(sl[0][2].toString()));
				prd.setDescription(sl[0][3].toString());
				prd.setTrademark_id(Integer.parseInt(sl[0][4].toString()));
				prd.setCategory_id(Integer.parseInt(sl[0][5].toString()));
				prd.setUser_username(sl[0][6].toString());
				prd.setHot(Integer.parseInt(sl[0][7].toString()));
				prd.setPhoto(sl[0][9].toString());
				//prd.setUpdate_time(new Date(sl[0][8].toString()));
			}
			catch(Exception ex){}	
		}
		return prd;
	}
	public static Product getNewProduct()
	{
		Product prd=null;
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		Object[][] sl=db.selectDataOrder(fields, "product", field, "update_time DESC");
		prd=convertToProduct(sl);
		return prd;
	}
	public static Product getProductById(int id)
	{
		Product prd=null;
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		Object[][] sl=db.selectDataWhere(fields, "product", field, "id="+id);
		prd=convertToProduct(sl);
		return prd;
	}
	public static ArrayList<Product> getTopNewProduct(int post,int amount)
	{
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		ArrayList<Object[]> sl=db.selectDataWhereOrderLimit(fields, "product", field, "id > 0", "update_time DESC ", post+", "+amount);
		return convertToListProduct(sl);
	}
	public static ArrayList<Product> getTopHotProduct(int post,int amount)
	{
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		ArrayList<Object[]> sl=db.selectDataWhereOrderLimit(fields, "product", field, "hot=1", "update_time DESC ", post+", "+amount);
		return convertToListProduct(sl);
	}
	
	public static ArrayList<Product> getTopProductOfCat_trade(int post,int amount,String where)
	{
		DbConnection db=new DbConnection();
		String fields=getFields();
		String[] field=getFieldArr();
		ArrayList<Object[]> sl=db.selectDataWhereOrderLimit(fields, "product", field, where, "update_time DESC ", post+", "+amount);
		return convertToListProduct(sl);
	}


}
