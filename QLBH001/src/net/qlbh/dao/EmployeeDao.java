/**
 * 
 */
package net.qlbh.dao;

import java.util.List;

import net.qlbh.entities.Employee;


/**
 * @author KISS
 *
 */
public interface EmployeeDao extends BaseDao {
	
	public int getTotalEmployees(String fullName);
	
	public List<Employee> getListEmployees(int offset, int limit, String name, String sortType, 
			String sortByName, String sortByRole);
	
	public Employee getUserByLogin(String username, String password);
	
	public void addNewEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
	public Employee getEmployeeById(int id);
	
	public boolean checkLogin(String username, String password);
}
