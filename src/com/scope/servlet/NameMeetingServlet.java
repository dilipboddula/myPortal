package com.scope.servlet;

import java.io.IOException;
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
import com.users.SapientUsers;
import com.users.SapientUsersDAO;
import com.users.SapientUsersImpl;

/**
 * Servlet implementation class NameMeetingServlet
 */
@WebServlet("/NameMeetingServlet")
public class NameMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameMeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int scopeId=(int) session.getAttribute("myScopeId");
		System.out.println("in names servlet scope "+scopeId);
		SapientUsersDAO ref=new SapientUsersImpl();
		ArrayList<SapientUsers> alist=ref.getAllUsers(scopeId);
		request.setAttribute("myUsersList",alist);
		
		AdminDAO ref2=new AdminImpl();
		ArrayList<Admin> al= ref2.getAllAdmins(scopeId);
		System.out.println("in names servlet");
		request.setAttribute("myUsersList2",al);
		RequestDispatcher rd=request.getRequestDispatcher("NamesSelectMeeting.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
