/**
 * 
 */
package net.qlbh.entities;

import java.util.Date;

/**
 * @author KISS
 *
 */
public class GuardProduct {
	private int productId;
	private int billId;
	private int status;
	private Date date;
	
	public GuardProduct(){}
	public GuardProduct(int idproduct, int idbill, int status, Date date){
		this.productId = idproduct;
		this.billId = idbill;
		this.status = status;
		this.date = date;
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
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
