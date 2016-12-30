package com.tav.toolshop.model;

import java.util.ArrayList;

import com.tav.toolshop.bean.Trademark;
import com.tav.toolshop.model.dao.DbConnection;

public class TrademarkModel {
	
	public static int addNewTrademark(Trademark ctg)
	{
		DbConnection db=new DbConnection();
		String fields="name, order_sort";
		String values="'"+ctg.getName()+"',"+ctg.getOrder_sort();
		return db.insertData("trademark", fields, values);
	}
	public static Trademark getTrademarkById(int id)
	{
		Trademark ctg=null;
		DbConnection db=new DbConnection();
		String fields="id, name, order_sort";
		String[] field=new String[3];
		field[0]="id";
		field[1]="name";
		field[2]="order_sort";
		Object[][] sl=db.selectDataWhere(fields, "trademark", field, "id="+id);
		if(sl.length!=0)
		{
			try
			{
				ctg=new Trademark();
				ctg.setId(id);
				ctg.setName(sl[0][1].toString());
				ctg.setOrder_sort(Integer.parseInt(sl[0][2].toString()));
			}
			catch(Exception ex){}
		}
		return ctg;
	}
	public static ArrayList<Trademark> getAllTrademark()
	{
		ArrayList<Trademark> list=new ArrayList<Trademark>();		
		DbConnection db=new DbConnection();
		String fields="id, name, order_sort";
		String[] field=new String[3];
		field[0]="id";
		field[1]="name";
		field[2]="order_sort";
		Object[][] sl=db.selectDataOrder(fields,"trademark", field, "order_sort");
		for(int i=0;i<sl.length;i++)
		{
			try
			{
			Trademark ct=new Trademark();
			ct.setId(Integer.parseInt(sl[i][0]+""));
			ct.setName(sl[i][1]+"");
			ct.setOrder_sort(Integer.parseInt(sl[i][2]+""));
			list.add(ct);
			}
			catch(NumberFormatException ne){}
		}
		return list;
	}
	public static int deleteTrademark(int id)
	{
		DbConnection db=new DbConnection();
		return db.deleteData("trademark", " id="+id);
	}
	public static int editTrademark(Trademark ctg)
	{
		DbConnection db=new DbConnection();
		String values=" name = '"+ctg.getName()+"', order_sort = "+ctg.getOrder_sort();
		return db.editData("trademark", values, "id = "+ctg.getId());
	}


}
