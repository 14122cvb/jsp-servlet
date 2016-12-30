/**
 * 
 */
package net.qlbh.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import net.qlbh.dao.BaseDao;
import net.qlbh.util.DatabaseProperties;

/**
 * @author KISS
 *
 */
public class BaseDaoImpl implements BaseDao {

	protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet rs = null;
    
	@Override
	public boolean connectToDatabase() {
		boolean result = true;
        try {
			// load mysql driver
			Class.forName(DatabaseProperties.getData("driver"));
			connection = DriverManager.getConnection(DatabaseProperties
					.getData("url"), DatabaseProperties.getData("user"),
					DatabaseProperties.getData("password"));
		} catch (Exception e) {
			System.out.println("an exception occur: " + e.getMessage());
			result = false;
		}
        return result;
	}
	
//	public static void main(String[] args) {
//		BaseDao base = new BaseDaoImpl();
//		if(base.connectToDatabase()){
//			System.out.println("ok");
//		}
//	}

	@Override
	public void closeConnect() {
		// TODO Auto-generated method stub
		 if (connection != null) {
	            try {
	                connection.close();
	            } catch (Exception e) {
	                System.out.println("an exception occur: " + e.getMessage());
	            }
	            connection = null;
	        }
	}
	
}
