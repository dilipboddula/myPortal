package com.users.servlets;

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

import com.model.ModelDAO;
import com.users.SapientUsers;
import com.users.SapientUsersDAO;
import com.users.SapientUsersImpl;

/**
 * Servlet implementation class AdminLoginCheckServlet
 */
@WebServlet("/UserLoginCheckServlet")
public class UserLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In action servlet");
		PrintWriter out=response.getWriter();
    	response.setContentType("text/html");
		String userSapientEmail=request.getParameter("userSapientEmail");
		String userPassword=request.getParameter("userPassword");
		SapientUsersDAO ref=new SapientUsersImpl();
		ArrayList<SapientUsers> al=ref.userLogin(userSapientEmail);
		if (al.size()==0){
			out.println("<h2> Either Your Sapient Email might have been entered Wrongly or your " +
					"Sapient Email is not yet registered with us. thank you</h2>");	
			
		}else {
			for (SapientUsers v : al) {
				if (userPassword.equals(v.getUserPassword())){
					HttpSession session=request.getSession();
					session.setAttribute("myUserName",v.getUserName());
					session.setAttribute("myUserId",v.getUserId());
					session.setAttribute("myScopeId", v.getScopeId());
					System.out.println("User Id in Http session is and scope id is "+v.getUserId()+"  "+v.getScopeId());
					
					response.sendRedirect("userView.jsp");
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
