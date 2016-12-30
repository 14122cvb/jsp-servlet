/**
 * 
 */
package net.qlbh.dao;

import java.util.List;

import net.qlbh.entities.Product;
import net.qlbh.entities.ProductInfo;

/**
 * @author KISS
 *
 */
public interface ProductDao extends BaseDao {
	
	public int getTotalProduct(String productName, int groupId);
	
	public List<ProductInfo> getListProducts(String productName, int groupId);
	
	public Product getProductById(int id);
	
	public void addNewProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int id);
}
