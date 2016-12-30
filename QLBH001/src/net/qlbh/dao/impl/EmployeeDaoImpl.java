/**
 * 
 */
package net.qlbh.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.qlbh.dao.EmployeeDao;
import net.qlbh.entities.Employee;

/**
 * @author KISS
 *
 */
public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {

	@Override
	public int getTotalEmployees(String name) {
		int totalRecord = 0;
		
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				//create SQL
				sqlCommand.append("SELECT COUNT(*) as total ");
				sqlCommand.append("FROM employee as e ");
				//search condition
				if("".equals(name)){
					sqlCommand.append(";");
				}else {
					sqlCommand.append("WHERE e.name LIKE %" + name + "% ;");
				}
				//run SQL
				preparedStatement  = connection.prepareStatement(sqlCommand.toString());
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
	public List<Employee> getListEmployees(int offset, int limit, String name, String sortType, 
			String sortByName, String sortByRole) {
		List<Employee> list = new ArrayList<Employee>();
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT * FROM employee as e ");
				//search condition
				if(!("".equals(name))){
					sqlCommand.append("WHERE e.name LIKE '%" + name + "%' ");
				}
				if("name".equals(sortType)){
					sqlCommand.append("ORDER BY e.name " + sortByName + " , e.role " + sortByRole + "");
				}else{
					if("role".equals(sortType)){
						sqlCommand.append("ORDER BY e.role " + sortByRole + " , e.name " + sortByName + "");
					}
				}
				sqlCommand.append(" LIMIT " + offset + " , " + limit);
				System.out.println(sqlCommand.toString());
				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();
				if(rs != null){
					while(rs.next()){
						Employee e = new Employee(rs.getInt("employeeId"), rs.getString("name"), 
								rs.getString("address"), rs.getString("phone"), rs.getString("email"),
								rs.getInt("role"), rs.getString("username"), rs.getString("password"));
						list.add(e);
					}
				}
				rs.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Employee getUserByLogin(String username, String password) {
		Employee e = null;
		if(connectToDatabase()){
		try{
			StringBuilder sqlCommand = new StringBuilder();
			sqlCommand.append("SELECT * FROM employee as e ");
			//search condition
			sqlCommand.append("WHERE e.username = '" + username + "' ");
			sqlCommand.append(" AND e.password = '" + password + "' ;");
			System.out.println(sqlCommand.toString());
			preparedStatement = connection.prepareStatement(sqlCommand.toString());
			rs = preparedStatement.executeQuery();
			if(rs != null){
				if(rs.next()){
					e = new Employee(rs.getInt("employeeId"), rs.getString("name"), 
							rs.getString("address"), rs.getString("phone"), rs.getString("email"),
							rs.getInt("role"), rs.getString("username"), rs.getString("password"));
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		}
		return e;
	}

	@Override
	public void addNewEmployee(Employee e) {
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("INSERT INTO employee(name, address, phone, email, role, username, password) VALUES "
						+ "('"+e.getName()+"' , '"+e.getAddress()+"' , '"+e.getPhone()+"', '"+e.getEmail()+"'"
								+ ", '"+e.getRole()+"', '"+e.getUsername()+"', '"+e.getPassword()+"') ;");
				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void updateEmployee(Employee e) {
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("UPDATE employee SET name = '"+e.getName()+"', address = '"+e.getAddress()+"'"
						+ ", phone = '"+e.getPhone()+"', email = '"+e.getEmail()+"', role = '"+e.getRole()+"'"
								+ ", username = '"+e.getUsername()+"', password = '"+e.getPassword()+"'");
				sqlCommand.append(" WHERE employeeId = '"+e.getEmployeeId()+"'");
				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void deleteEmployee(int id) {
		if(connectToDatabase()){
			try{
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("DELETE FROM employee WHERE employeeId = '"+id+"' ;");
				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.execute();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	@Override
	public boolean checkLogin(String username, String password) {
		boolean result = false;
		if(connectToDatabase()){
		try{
			StringBuilder sqlCommand = new StringBuilder();
			sqlCommand.append("SELECT COUNT(*) as total FROM employee ");
			//search condition
			sqlCommand.append(" WHERE username = '"+username+"' AND password = '"+password+"' ;");
			
			preparedStatement = connection.prepareStatement(sqlCommand.toString());
			rs = preparedStatement.executeQuery();

			if(rs != null){
				while(rs.next()){
					if(rs.getInt("total")==1){
						result = true;
					}
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		EmployeeDao e = new EmployeeDaoImpl();
		Employee em = e.getEmployeeById(1);
		System.out.println(em.getEmployeeId());
	}


	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null;
		if(connectToDatabase()){
		try{
			StringBuilder sqlCommand = new StringBuilder();
			sqlCommand.append("SELECT * FROM employee as e ");
			//search condition
			sqlCommand.append(" WHERE e.employeeId = '" + id + "' ;");
			System.out.println(sqlCommand.toString());
			
			preparedStatement = connection.prepareStatement(sqlCommand.toString());
			rs = preparedStatement.executeQuery();
			
			if(rs != null){
				if(rs.next()){
					e = new Employee(rs.getInt("employeeId"), rs.getString("name"), 
							rs.getString("address"), rs.getString("phone"), rs.getString("email"),
							rs.getInt("role"), rs.getString("username"), rs.getString("password"));
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}}
		return e;
	}
}
