/**
 * 
 */
package net.qlbh.entities;

import java.util.Date;

/**
 * @author KISS
 *
 */
public class Bill {
	private int billId;
	private int customerId;
	private Date date;
	private String payType;
	private int processStatus;
	private int payStatus;
	private int employeeId;
	
	public Bill(){}
	public Bill(int idbill, int idcustomer, Date date, String type, int process, int pay, int employee){
		this.billId = idbill;
		this.customerId = idcustomer;
		this.date = date;
		this.payType = type;
		this.processStatus = process;
		this.payStatus = pay;
		this.employeeId = employee;
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
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * @return the processStatus
	 */
	public int getProcessStatus() {
		return processStatus;
	}
	/**
	 * @param processStatus the processStatus to set
	 */
	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}
	/**
	 * @return the payStatus
	 */
	public int getPayStatus() {
		return payStatus;
	}
	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
