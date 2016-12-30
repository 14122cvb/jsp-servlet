/**
 * 
 */
package net.qlbh.dao;

/**
 * @author KISS
 *
 */
public interface BaseDao {
	
	
	public boolean connectToDatabase();
	
	public void closeConnect();
}
