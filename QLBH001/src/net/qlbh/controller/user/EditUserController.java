package net.qlbh.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.qlbh.dao.impl.EmployeeDaoImpl;
import net.qlbh.entities.Employee;

/**
 * Servlet implementation class EditUserController
 */
@WebServlet("/EditUserController")
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String name = request.getParameter("fullname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int role = Integer.parseInt(request.getParameter("role"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(request.getContextPath());
		
		Employee employee = new Employee(id, name, address, phone, email, role, username, password);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.updateEmployee(employee);
		response.sendRedirect(request.getContextPath() + "/admin/ListUser.do");
	}

}
