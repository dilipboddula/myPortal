package com.users.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.users.SapientUsers;
import com.users.SapientUsersDAO;
import com.users.SapientUsersImpl;

/**
 * Servlet implementation class NameDisplayServlet
 */
@WebServlet("/NameDisplayServlet")
public class NameDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static SessionFactory factory;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int scopeId=(int) session.getAttribute("myScopeId");
		System.out.println("in names servlet scope "+scopeId);
		SapientUsersDAO ref=new SapientUsersImpl();
		ArrayList<SapientUsers> alist=ref.getAllUsers(scopeId);
		request.setAttribute("myUsersList",alist);
		System.out.println("in names servlet");
		RequestDispatcher rd=request.getRequestDispatcher("NamesSelect.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
