package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.*;

import com.admin.AdminDAO;
import com.admin.AdminImpl;
import com.users.SapientUsers;
import com.users.SapientUsersDAO;
import com.users.SapientUsersImpl;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("in do get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	static SessionFactory factory;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		System.out.println("in CP Servlet");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String curPassword=request.getParameter("curPassword");
		System.out.println("cur password"+curPassword);
		String newPassword=request.getParameter("newPassword");
		System.out.println("new password"+newPassword);
		HttpSession httpsession=request.getSession();
		int scopeId=(int) httpsession.getAttribute("myScopeId");
		String differentiator=request.getParameter("differentiator");
		int id=0;
		int result=0;
		String nameRole=null;
		if(differentiator.equals("abc")){
			id=(int) httpsession.getAttribute("myUserId");
			SapientUsersDAO ref=new SapientUsersImpl();
			result=ref.changePassword(id, scopeId, newPassword, curPassword);
		}else if(differentiator.equals("def")){
			id=(int) httpsession.getAttribute("myAdminId");
			AdminDAO ref=new AdminImpl();
			result=ref.changePassword(id, scopeId, newPassword, curPassword);
			}
		if (result==1){
		out.println("<h2>your password changed successfully</h2>");
		return;
		}else if (result==0){
			out.println("<h2>Error in Changing password</h2>");
			return;
		}else if (result==-1){
			out.println("<h2>Current password is wrong</h2>");
			return;
		}
	}

}
