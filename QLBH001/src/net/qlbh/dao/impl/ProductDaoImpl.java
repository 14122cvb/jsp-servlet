/**
 * 
 */
package net.qlbh.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.qlbh.dao.ProductDao;
import net.qlbh.entities.Product;
import net.qlbh.entities.ProductInfo;

/**
 * @author KISS
 *
 */
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

	@Override
	public int getTotalProduct(String productName, int groupId) {
		int totalRecord = 0;
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT COUNT(*) AS total FROM product as p ");
				sqlCommand.append(" LEFT JOIN qlbh.group AS g ON p.groupId = g.groupId ");
				sqlCommand.append( "LEFT JOIN qlbh.supply AS s ON p.supplyId = s.supplyId ");
				if(!"".equals(productName)){
					sqlCommand.append("WHERE p.productName LIKE '%"+productName+"%' ");
					if(groupId > 0){
						sqlCommand.append(" AND p.groupId = '"+groupId+"'");
					}
				}
				else{
					if(groupId>0){
						sqlCommand.append("WHERE p.groupId = "+groupId);
					}
				}
				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();
				if(rs != null){
					while(rs.next()){
						totalRecord = rs.getInt("total");
					}
				}
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return totalRecord;
	}

	@Override
	public List<ProductInfo> getListProducts(String productName, int groupId) {
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT p.productId, p.productName, p.describe, p.price, p.amount"
						+ " , g.groupName, s.name FROM product as p ");
				sqlCommand.append(" LEFT JOIN qlbh.group AS g ON p.groupId = g.groupId ");
				sqlCommand.append( "LEFT JOIN qlbh.supply AS s ON p.supplyId = s.supplyId ");
				if(!"".equals(productName)){
					sqlCommand.append("WHERE p.productName LIKE '%"+productName+"%' ");
					if(groupId > 0){
						sqlCommand.append(" AND p.groupId = '"+groupId+"'");
					}
				}
				else{
					if(groupId>0){
						sqlCommand.append("WHERE p.groupId = "+groupId);
					}
				}
				System.out.println(sqlCommand.toString());
				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();
				if(rs != null){
					while(rs.next()){
						ProductInfo productInfo = new ProductInfo(rs.getInt("productId"), rs.getString("productName"),
								rs.getString("describe"), rs.getInt("price"), rs.getInt("amount"),
								rs.getString("groupName"), rs.getString("name"));
						list.add(productInfo);
					}
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Product getProductById(int id) {
		Product product = null;
		if(connectToDatabase()){
			try{
				String sqlCommand = "SELECT * FROM product AS p WHERE p.productId = '"+id+"'";
				preparedStatement = connection.prepareStatement(sqlCommand);
				rs = preparedStatement.executeQuery();
				if(rs != null){
					while(rs.next()){
						product = new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("image1"),
								rs.getString("image2"), rs.getString("image3"),rs.getString("image4"),rs.getString("image5"),
								rs.getString("describe"), rs.getInt("price"), rs.getInt("amount"), rs.getInt("supplyID"),
								rs.getInt("groupId"));
					}
				}
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public void addNewProduct(Product product) {
		// TODO Auto-generated method stub
		if(connectToDatabase()){
			try{
				String sqlCommand = "INSERT INTO product(productName, image1, image2, image3, image4, image5, describe,"
						+ "price, amount, supplyId, groupId) values ('"+product.getProductName()+"','"+product.getImage1()+""
						+ "','"+product.getImage2()+"','"+product.getImage3()+"','"+product.getImage4()+"',"
						+ "'"+product.getImage5()+"','"+product.getDescribe()+"',"
						+ "'"+product.getPrice()+"','"+product.getAmount()+"','"+product.getSupplyId()+"','"+product.getGroupId()+"')";
				System.out.println(sqlCommand);
				preparedStatement = connection.prepareStatement(sqlCommand);
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		if(connectToDatabase()){
			try{
				String sqlCommand = "UPDATE product AS p SET productName = '"+product.getProductName()+"', image1 = '"+product.getImage1()+"'"
						+ ", image2 = '"+product.getImage2()+"', image3 = '"+product.getImage3()+"', image4 = '"+product.getImage4()+"',"
								+ " image5 = '"+product.getImage5()+"', p.describe = '"+product.getDescribe()+"', price = '"+product.getPrice()+"'"
										+ ", amount = '"+product.getAmount()+"', supplyId = '"+product.getSupplyId()+"', groupId = '"+product.getGroupId()+"'"
												+ " WHERE p.productID = '"+product.getProductId()+"'";
				System.out.println(sqlCommand);
				preparedStatement = connection.prepareStatement(sqlCommand);
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		if(connectToDatabase()){
			try{
				String sqlCommand = "DELETE FROM product WHERE productId = '"+id+"'";
				System.out.println(sqlCommand);
				preparedStatement = connection.prepareStatement(sqlCommand);
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ProductDaoImpl p = new ProductDaoImpl();
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		Product pt = new Product(20,"Tu lanh 123","","","","","","Tu lanh",100,100,5,5);
		p.deleteProduct(20);
	}
}
