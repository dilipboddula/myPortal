package com.scope;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.HibernateUtil;
import com.test.SapientUsers;

/**
 * Servlet implementation class GetNames
 */
@WebServlet("/GetNames")
public class GetNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNames() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static SessionFactory factory;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String scopeDummy=request.getParameter("batchDetails");
		int scopeid=Integer.parseInt(scopeDummy);
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		SQLQuery query=null;		
		query = session.createSQLQuery("SELECT * FROM namesbean WHERE scopeid=? ");
		query.addEntity(NamesBean.class);
		query.setParameter(0, scopeid);
		ArrayList<NamesBean> alist=(ArrayList<NamesBean>)query.list();
		request.setAttribute("myNamesList",alist);
		System.out.println("in names servlet");
		RequestDispatcher rd=request.getRequestDispatcher("userRegistrationForm.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
