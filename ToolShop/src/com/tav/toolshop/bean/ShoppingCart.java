package com.tav.toolshop.bean;

import java.util.Enumeration;
import java.util.Hashtable;

public class ShoppingCart {
	
	private Hashtable items=new Hashtable();
	
	public void addItem(String itemId, String desc, double price, int quantity)
	{
		String[] item={itemId,desc,price+"",quantity+""}; 
		if(items.containsKey(itemId))
		{
			String[] tmpItem=(String[])items.get(itemId);
			int tmpQuantity=0;
			try
			{
			  tmpQuantity=Integer.parseInt(tmpItem[3]);
			}
			catch(Exception ex){}
			quantity+=tmpQuantity;
			tmpItem[3]=quantity+"";
		}
		else
		{
			items.put(itemId, item);
		}
	}
	public void removeItem(String itemId)
	{
		if(items.contains(itemId))
			items.remove(itemId);
	}
	public void updateQuantity(String itemId, int quantity)
	{
		if(items.contains(itemId))
		{
			String[] tmpItem=(String[])items.get(itemId);
			tmpItem[3]=quantity+"";
		}
	}
	public Enumeration getEnumeration()
	{
		return items.elements();
	}
	public double getCost()
	{
		Enumeration enums=items.elements();
		double total=0.0;
		while(enums.hasMoreElements())
		{
			String[] tmpItem=(String[])enums.nextElement();
			total+=(Integer.parseInt(tmpItem[3]))*(Double.parseDouble(tmpItem[2]));
		}
		return total;
	}
	public int getNumberItem()
	{
		Enumeration enums=items.elements();
		int count=0;
		while(enums.hasMoreElements())
		{
			String[] tmpItem=(String[])enums.nextElement();
			count+=Integer.parseInt(tmpItem[3]);
		}
		return count;
	}

}
