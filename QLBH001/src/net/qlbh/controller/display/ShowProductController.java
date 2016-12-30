package net.qlbh.controller.display;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.qlbh.dao.impl.GroupDaoImpl;
import net.qlbh.dao.impl.ProductDaoImpl;
import net.qlbh.entities.Group;
import net.qlbh.entities.ProductInfo;
import net.qlbh.util.Common;

/**
 * Servlet implementation class ShowProductController
 */
@WebServlet("/ShowProductController")
public class ShowProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductController() {
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
		try{
			System.out.println("Vào controller product");
			GroupDaoImpl gdi = new GroupDaoImpl();
			ProductDaoImpl pdi = new ProductDaoImpl();
			List<ProductInfo> listProduct = new ArrayList<ProductInfo>();
			List<Group> listGroup = new ArrayList<Group>();
			HttpSession session = request.getSession();
			//
			String keyNameSearch = "";
			int groupId = 0;
			String contextPath = request.getContextPath();

				if (request.getParameter("key_name_search_product") != null) {
					keyNameSearch = request.getParameter("key_name_search_product").toString();
                } else {
                    if (session.getAttribute("key_name_search_product") != null) {
                    	keyNameSearch = session.getAttribute("key_name_search_product").toString();
                    }
                }
				
				if (request.getParameter("group_id") != null) {
					groupId = Integer.parseInt(request.getParameter("group_id").toString());
                } else {
                    if (session.getAttribute("group_id") != null) {
                    	groupId = Integer.parseInt(session.getAttribute("group_id").toString());
                    }
                }
				
				listGroup = gdi.getListGroups();
				listProduct = pdi.getListProducts(Common.escapeInjection(keyNameSearch), groupId);
				
				request.setAttribute("list_product", listProduct);
				request.setAttribute("list_group", listGroup);
				session.setAttribute("key_name_search_product", keyNameSearch);
				session.setAttribute("group_id", groupId);
				RequestDispatcher req = request.getRequestDispatcher("list_product.jsp");
	            req.forward(request, response);

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
