/**
 * 
 */
package net.qlbh.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.qlbh.dao.GroupDao;
import net.qlbh.entities.Group;

/**
 * @author KISS
 *
 */
public class GroupDaoImpl extends BaseDaoImpl implements GroupDao {

	@Override
	public int getTotalGroups() {
		int totalRecord = 0;
		if(connectToDatabase()){
			try{
				System.out.println("conn ok");
				String sqlCommand = "SELECT COUNT(*) AS total FROM qlbh.group";
				preparedStatement  = connection.prepareStatement(sqlCommand);
				rs = preparedStatement.executeQuery();
				//get result
				if(rs != null){
				while(rs.next()){
					totalRecord = rs.getInt("total");
				}
				rs.close();
				}
			}
			catch(SQLException ex){
			ex.printStackTrace();
			}
		}
		return totalRecord;
	}

	@Override
	public List<Group> getListGroups() {
		List<Group> list  = new ArrayList<Group>();
		if(connectToDatabase()){
			try{
				System.out.println("conn ok");
				String sqlCommand = "SELECT * FROM qlbh.group ";
				System.out.println(sqlCommand);
				preparedStatement = connection.prepareStatement(sqlCommand);
				
				rs = preparedStatement.executeQuery();
				if(rs != null){
					while(rs.next()){
						Group g = new Group(rs.getInt("groupId"), rs.getString("groupName"), rs.getString("describe"));
						list.add(g);
					}
				}
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void addNewGroup(Group group) {
		if(connectToDatabase()){
			try{
				System.out.println("conn ok");
				String sqlCommand = "INSERT INTO qlbh.group(groupName, group.describe) values"
						+ "('"+group.getGroupName()+"','"+group.getDescribe()+"')";
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
	public void updateGroup(Group group) {
		if(connectToDatabase()){
			try{
				String sqlCommand = "UPDATE qlbh.group as g SET groupName = '"+group.getGroupName()+"', g.describe ="
						+ " '"+group.getDescribe()+"' WHERE g.groupId = '"+group.getGroupId()+"'";
				preparedStatement = connection.prepareStatement(sqlCommand);
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void deleteGroup(int id) {
		if(connectToDatabase()){
			try{
				String sqlCommand = "delete from qlbh.group where groupId = '"+id+"'";
				preparedStatement = connection.prepareStatement(sqlCommand);
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}

	@Override
	public Group getGroupById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		GroupDaoImpl g = new GroupDaoImpl();
		Group gr = new Group(6, "Điện thoại123423","Điện thoại");
		g.deleteGroup(6);
		
	}
}
