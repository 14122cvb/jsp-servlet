package com.tav.toolshop.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DbConnection {
	
	private String host="";
	private String port="";
	private String dbName="";
	private String userName="";
	private String password="";	
	private Connection con;

	public DbConnection()
	{
		readConfig();
		connect();
	}
	public void readConfig()
	{
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			 
			input = this.getClass().getClassLoader().getResourceAsStream("../config/db.properties");
			prop.load(input);
			host=prop.getProperty("host");
			port=prop.getProperty("port");
			dbName=prop.getProperty("dbName");
			userName=prop.getProperty("userName");
			password=prop.getProperty("password");
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void connect()
	{
        String url = "jdbc:mysql://"+host+":"+port+"/";
        String driver = "com.mysql.jdbc.Driver";

  
        try
        {
        	Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url+dbName,userName,password);           
        }
        catch(Exception ex){
        	System.out.println("ee "+ex);
        }
	
	}
	
	public Object[][] selectData(String fields, String tableName, String[] field)
	{
		try
		{
			int count=0;
			Statement statement = con.createStatement(); 
			ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName);
		    while(resultSet_count.next()){
		    count = resultSet_count.getInt("Rows");
		    }
		    resultSet_count.close();
			ResultSet resultSet = statement  
                    .executeQuery("SELECT "+fields+" FROM  "+tableName); 
			Object[][] data = new Object[count][field.length];
	        int row=0;
	        while (resultSet.next()) { 
	        	 for(int i=0;i<field.length; i++)
	        	 {
	        		 data[row][i] = resultSet.getString(field[i]);
	        	 }
	        	 row++;
	        }
	       resultSet.close();
	       statement.close();
	       con.close();
	        
	        return data; 
		}
		catch(Exception ex){ 
	       	return null;
	    } 
		
	}
	
	public Object[][] selectDataOrder(String fields, String tableName, String[] field, String order_param)
	{
		try
		{
			int count=0;
			Statement statement = con.createStatement(); 
			ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName);
		    while(resultSet_count.next()){
		    count = resultSet_count.getInt("Rows");
		    }
		    resultSet_count.close();
			ResultSet resultSet = statement.executeQuery("SELECT "+fields+" FROM  "+tableName+" order by "+order_param); 
			Object[][] data = new Object[count][field.length];  
	        int row=0;
	        while (resultSet.next()) { 
	        	 for(int i=0;i<field.length; i++)
	        	 {
	        		 data[row][i] = resultSet.getString(field[i]);
	        	 }

	        	 row++;
	        }  
	       resultSet.close();
	       statement.close();
	       con.close();
	        
	        return data; 
		}
		catch(Exception ex){ 
	       	return null;
	    } 
		
	}
	
	public Object[][] selectDataWhere(String fields, String tableName, String[] field, String where)
	{
		try
		{
			int count=0;
			Statement statement = con.createStatement(); 
			ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName+" where "+where);
		    System.out.println("SELECT COUNT(*) AS Rows FROM "+tableName+" where "+where);
			while(resultSet_count.next()){
		    count = resultSet_count.getInt("Rows");
		    }
		    resultSet_count.close();
			ResultSet resultSet = statement  
                    .executeQuery("SELECT "+fields+" FROM  "+tableName+" where "+where); 
			Object[][] data = new Object[count][field.length];  
	        int row=0;
	        while (resultSet.next()) { 
	        	 for(int i=0;i<field.length; i++)
	        	 {
	        		 data[row][i] = resultSet.getString(field[i]);
	        	 }

	        	 row++;
	        }  
	       resultSet.close();
	       statement.close();
	       con.close();
	        
	        return data; 
		}
		catch(Exception ex){ 
	       	return null;
	    } 
		
	}
	public Object[][] selectDataWhereOrder(String fields, String tableName, String[] field, String where, String order_param)
	{
		try
		{
			int count=0;
			Statement statement = con.createStatement(); 
			ResultSet resultSet_count = statement.executeQuery("SELECT COUNT(*) AS Rows FROM "+tableName+" where "+where);
		    System.out.println("SELECT COUNT(*) AS Rows FROM "+tableName+" where "+where);
			while(resultSet_count.next()){
		    count = resultSet_count.getInt("Rows");
		    }
		    resultSet_count.close();
			ResultSet resultSet = statement  
                    .executeQuery("SELECT "+fields+" FROM  "+tableName+" where "+where+" order by "+order_param); 
			Object[][] data = new Object[count][field.length];  
	        int row=0;
	        while (resultSet.next()) { 
	        	 for(int i=0;i<field.length; i++)
	        	 {
	        		 data[row][i] = resultSet.getString(field[i]);
	        	 }

	        	 row++;
	        }  
	       resultSet.close();
	       statement.close();
	       con.close();
	        
	        return data; 
		}
		catch(Exception ex){ 
	       	return null;
	    } 
		
	}
	
	public ArrayList<Object[]> selectDataWhereOrderLimit(String fields, String tableName, String[] field, String where, String order_param, String limit)
	{
		ArrayList<Object[]> obj=new ArrayList<Object[]>();
		try
		{
			Statement statement = con.createStatement(); 
			ResultSet resultSet = statement  
                    .executeQuery("SELECT "+fields+" FROM  "+tableName+" where "+where+" order by "+order_param+" LIMIT "+limit); 
	        while (resultSet.next()) { 
	        	 Object[] data = new Object[field.length]; 
	        	 for(int i=0;i<field.length; i++)
	        	 {
	        		 data[i] = resultSet.getString(field[i]);
	        		 
	        	 }
	        	 obj.add(data);
	        }  
	       resultSet.close();
	       statement.close();
	       con.close();
	        
	        return obj; 
		}
		catch(Exception ex){ 
	       	return null;
	    } 
		
	}
	
	//Thêm dữ liệu vào bảng
	public int insertData(String tblName, String fields, String values)
	{
		try { 
			Statement statement = con.createStatement(); 
			statement.executeUpdate("INSERT INTO " +tblName+" ( "+fields+" )"+" VALUES ( "+ 
                values+" )"); 
            statement.close();
            con.close(); 
            return 1;
        } catch (Exception e) { 
        	System.out.println("ss"+e);
        	return 0;
        } 
	}
	//Sửa dữ liệu trong bảng
	public int editData(String tblName, String values, String where)
	{
		try { 
			Statement statement = con.createStatement(); 
			String query = "update "+tblName+" set "+values+" where "+where;
			PreparedStatement  update= con.prepareStatement(query);
			update.executeUpdate();
			update.close();
			statement.close();
            con.close(); 
            return 1;
        } catch (Exception e) { 
        	return 0;
        } 
	}
	//Xóa dữ liệu
	public int deleteData(String table, String where)
	{
		String query = "DELETE FROM "+table+" WHERE "+where;
        try {
        	Statement statement = con.createStatement(); 
        	statement.execute(query);
        	statement.close();
            con.close();
            return 1;
        } catch (Exception ex) {
            return 0;
        }
	}


}
