package com.shoestore.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.shoestore.bean.Category;
import com.shoestore.bean.Product;






public class Dbconnection {
	private String host;
	private String port;
	private String dbname;
	private String username;
	private String password;
	private Connection con;
	
	public Dbconnection()
	{
		readconfig();
		connect();
	}
	
	public void readconfig()
	{
		Properties prop = new Properties();
		InputStream input = null;
		
		try
		{
			input = this.getClass().getClassLoader().getResourceAsStream("../config/db.properties");
			prop.load(input);
			
			host = prop.getProperty("host");
			port = prop.getProperty("port");
			dbname = prop.getProperty("dbname");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			System.out.println("host = "+host+"\t"+"port = "+port);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			try
			{
				if(input!=null)
				{
					input.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
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
			con = DriverManager.getConnection(url + dbname,username,password);
			System.out.println("Connect completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void closeconnection()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int checklogin(String username,String password)
	{
		int kt = 0;
		try
		{
			Statement stmt;
			stmt = con.createStatement();
			
			String sql = "select * from dkt_user where username = '"+username+"' and password = '"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("kt_start = "+kt);
				kt++;
				System.out.println("kt = "+kt);
			}
			rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return kt;
	}
	
	
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> list = new ArrayList<Category>();
		try
		{
			Statement stmt;
			stmt = con.createStatement();
			
			String sql = "select * from dkt_categories";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Category ct = new Category();
				ct.setId(rs.getInt("id"));
				ct.setName(rs.getString("name"));
				ct.setImage(rs.getString("image"));
				ct.setDescription(rs.getString("description"));
				
				list.add(ct);
			}
			rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Product> getAllProduct()
	{
		ArrayList<Product> list = new ArrayList<Product>();
		
		try
		{
			Statement stmt;
			stmt = con.createStatement();
			
			String sql = "select * from dkt_products ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Product pr = new Product();
				pr.setName(rs.getString("name"));
				pr.setPrice(rs.getDouble("price"));
				pr.setImage(rs.getString("image"));
				pr.setDescription(rs.getString("description"));
				pr.setId(rs.getString("id"));
				
				list.add(pr);
			}
			rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public Product getProductById(int id)
	{
		Product prd = new Product();
		
		try
		{
			Statement stmt;
			stmt = con.createStatement();
			
			String sql = "select * from dkt_products where id="+id;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				prd.setName(rs.getString("name"));
				prd.setPrice(rs.getDouble("price"));
				prd.setImage(rs.getString("image"));
				prd.setDescription(rs.getString("description"));
				prd.setId(rs.getString("id"));
				
			}
			rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prd;
	}
	
	
	public int insertData(String tablename, String fields, String value)
	{
		String query = "insert into "+tablename+" ( "+fields+" ) " + " values " + " ( "+ value + " ) ";
		System.out.println(query);
		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
	public int editData(String tablename, String value,String where)
	{
		String query = "update "+tablename+"set "+value+"where "+where;
		try
		{
			Statement stmt = con.createStatement();
			PreparedStatement edit = con.prepareStatement(query);
			edit.executeUpdate();
			edit.close();
			stmt.close();
			return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
	
	public int deleteData(String tablename,String where)
	{
		String query = "delete from "+tablename+" where "+where;
		try
		{
			Statement stmt = con.createStatement();
			stmt.execute(query);
			stmt.close();
			return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
	public int editData_Product()
	{
		try
		{
			String query = "update dkt_product set price = 100,name = 'hang moi ve' where id = 1";
			
			PreparedStatement update = con.prepareStatement(query); 
			update.executeUpdate();
			update.close();//statement.close();
			con.close();
			return 1;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
