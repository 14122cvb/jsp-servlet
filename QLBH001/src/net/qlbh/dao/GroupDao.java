/**
 * 
 */
package net.qlbh.dao;

import java.util.List;

import net.qlbh.entities.Group;

/**
 * @author KISS
 *
 */
public interface GroupDao extends BaseDao {
	
	public int getTotalGroups();
	
	public List<Group> getListGroups();
	
	public void addNewGroup(Group employee);
	
	public void updateGroup(Group employee);
	
	public void deleteGroup(int id);
	
	public Group getGroupById(int id);
}
