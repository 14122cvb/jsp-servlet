/**
 * 
 */
package net.qlbh.entities;

/**
 * @author KISS
 *
 */
public class Supply {
	private int supplyId;
	private String name;
	private String address;
	private String accountNumber;
	private String phone;
	
	public Supply(){}
	public Supply(int id, String name, String address, String accnumber, String phone){
		this.supplyId = id;
		this.name = name;
		this.address = address;
		this.accountNumber = accnumber;
		this.phone = phone;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
