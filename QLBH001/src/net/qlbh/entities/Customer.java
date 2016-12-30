/**
 * 
 */
package net.qlbh.entities;

import java.util.Date;

/**
 * @author KISS
 *
 */
public class Customer {
	private int customerId;
	private String customerName;
	private String address;
	private String phone;
	private String cardType;
	private String cardNumber;
	private String cardName;
	private Date expireDate;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	public Customer(){}
	public Customer(int id, String name, String address, String phone, String cardtype, String cardname,
			String cardnumber, Date expriredate){
		this.customerId = id;
		this.customerName = name;
		this.address = address;
		this.phone = phone;
		this.cardType = cardtype;
		this.cardName = cardname;
		this.cardNumber = cardnumber;
		this.expireDate = expriredate;
	}
}
