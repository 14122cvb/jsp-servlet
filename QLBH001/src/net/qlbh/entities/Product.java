/**
 * 
 */
package net.qlbh.entities;

/**
 * @author KISS
 *
 */
public class Product {
	private int productId;
	private String productName;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String describe;
	private int price;
	private int amount;
	private int supplyId;
	private int groupId;
	
	public Product(){}
	public Product(int id, String name, String img1, String img2, String img3, String img4, String img5,
			String describe, int price, int amount, int supplyid, int groupId){
		this.productId = id;
		this.productName = name;
		this.groupId = groupId;
		this.image1 = img1;
		this.image2 = img2;
		this.image3 = img3;
		this.image4 = img4;
		this.image5 = img5;
		this.describe = describe;
		this.price = price;
		this.amount = amount;
		this.supplyId = supplyid;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the image1
	 */
	public String getImage1() {
		return image1;
	}
	/**
	 * @param image1 the image1 to set
	 */
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	/**
	 * @return the image2
	 */
	public String getImage2() {
		return image2;
	}
	/**
	 * @param image2 the image2 to set
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	/**
	 * @return the image3
	 */
	public String getImage3() {
		return image3;
	}
	/**
	 * @param image3 the image3 to set
	 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	/**
	 * @return the image4
	 */
	public String getImage4() {
		return image4;
	}
	/**
	 * @param image4 the image4 to set
	 */
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	/**
	 * @return the image5
	 */
	public String getImage5() {
		return image5;
	}
	/**
	 * @param image5 the image5 to set
	 */
	public void setImage5(String image5) {
		this.image5 = image5;
	}
	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * @param describe the describe to set
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the supplyId
	 */
	public int getSupplyId() {
		return supplyId;
	}
	/**
	 * @param supplyId the supplyId to set
	 */
	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}
	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
	
}
