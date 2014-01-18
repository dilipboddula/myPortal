package com.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out=response.getWriter();
    	response.setContentType("text/html");
		String userSapientEmail=request.getParameter("userSapientEmail");
		SapientUsersDAO s=new SapientUsersImpl();
		
		int scopeId;
		scopeId=s.checkMailIdInNames(userSapientEmail);
		if (scopeId==0){
			out.println("<h2> Either Your Sapient Email might have been entered Wrongly or your " +
					"Sapient Email is not yet registered with us. thank you</h2>");	
			
		}else if (scopeId==-1){
			out.println("<h2> you are already registered with us. Duplicate registrations are not allowed</h2>");	
		}else{
		String userName=request.getParameter("userName");
		String userEmail=request.getParameter("userEmail");				
		String userPassword =request.getParameter("userPassword");				
		String p =request.getParameter("userPhone");
		long userPhone=Long.parseLong(p);
		String userGender=request.getParameter("userGender");
		String userAddress=request.getParameter("userAddress");
		SapientUsers a=new SapientUsers();
		a.setScopeId(scopeId);
		a.setUserAddress(userAddress);
		a.setUserEmail(userEmail);
		a.setUserGender(userGender);
		a.setUserName(userName);
		a.setUserPassword(userPassword);
		a.setUserPhone(userPhone);
		a.setUserSapientEmail(userSapientEmail);
		int userId=s.addUser(a);
		a.setUserId(userId);
		if (userId==0){
			out.println("<h2> Error in insertion. we will get back to u soon. Thank u</h2>");
		}else{
		out.println("<h2> Registration successFull. Your userId is "+userId+"</h2>");	
		}
 		} 	
		RequestDispatcher rd=request.getRequestDispatcher("plain.jsp");
		rd.include(request, response);
		
	     
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
