package com.admin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.Admin;
import com.admin.AdminDAO;
import com.admin.AdminImpl;

/**
 * Servlet implementation class AdminLoginCheckServlet
 */
@WebServlet("/AdminLoginCheckServlet")
public class AdminLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminUserName=request.getParameter("adminUserName");
		String adminPassword=request.getParameter("adminPassword");
		PrintWriter out=response.getWriter();
    	response.setContentType("text/html");
		AdminDAO ref=new AdminImpl();
		ArrayList<Admin> al=ref.adminLogin(adminUserName);
		if (al.size()==0){
			out.println("<h2> Either Your Login Id might have been entered Wrongly or your " +
					"Login is not yet registered with us. thank you</h2>");	
			
		}else {
			for (Admin v : al) {
				if (adminPassword.equals(v.getAdminPassword())){
					HttpSession session=request.getSession();
					session.setAttribute("myScopeId", v.getScopeId());
					session.setAttribute("myAdminId", v.getAdminId());
					System.out.println("User Id in Http session is "+v.getAdminId());
					session.setAttribute("myRole", v.getAdminRole());
					response.sendRedirect("adminRedirect.jsp");
					/*RequestDispatcher rd=request.getRequestDispatcher("userView.jsp");
					rd.forward(request,response);*/
					return;
				}else{
					out.println("<h2>Invalid Credentials</h2>");	
					RequestDispatcher rd=request.getRequestDispatcher("plain.jsp");
					rd.include(request,response);
				}
			}
				}

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
