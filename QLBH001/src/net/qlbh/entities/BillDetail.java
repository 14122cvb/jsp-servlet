/**
 * 
 */
package net.qlbh.entities;

/**
 * @author KISS
 *
 */
public class BillDetail {
	private int idBillDetail;
	private int billId;
	private int productId;
	private int amount;
	private int price;
	
	public BillDetail(){}
	public BillDetail(int idbilld, int idbill, int idpro, int amount, int price){
		this.idBillDetail = idbilld;
		this.billId = idbill;
		this.productId = idpro;
		this.amount = amount;
		this.price = price;
	}
	
	/**
	 * @return the idBillDetail
	 */
	public int getIdBillDetail() {
		return idBillDetail;
	}
	/**
	 * @param idBillDetail the idBillDetail to set
	 */
	public void setIdBillDetail(int idBillDetail) {
		this.idBillDetail = idBillDetail;
	}
	/**
	 * @return the billId
	 */
	public int getBillId() {
		return billId;
	}
	/**
	 * @param billId the billId to set
	 */
	public void setBillId(int billId) {
		this.billId = billId;
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
}
