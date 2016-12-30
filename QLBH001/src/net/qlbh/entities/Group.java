/**
 * 
 */
package net.qlbh.entities;

/**
 * @author KISS
 *
 */
public class Group {
	private int groupId;
	private String groupName;
	private String describe;
	
	public Group(){}
	public Group(int id, String _name, String des){
		this.groupId = id;
		this.groupName = _name;
		this.describe = des;
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
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	
	
}
