package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.Assignment;
import com.assignment.AssignmentImpl;
import com.assignment.AssignmentDAO;

/**
 * Servlet implementation class GetAssignmentServlet
 */
@WebServlet("/GetAssignmentServlet")
public class GetAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		AssignmentDAO w=new AssignmentImpl();
		ArrayList<Assignment> al=new ArrayList<Assignment>();
		HttpSession session=request.getSession();
      	int scopeId=(int) session.getAttribute("myScopeId");
		al=w.getAllAssignments(scopeId);
		request.setAttribute("myAssignments", al);
		RequestDispatcher rd=request.getRequestDispatcher("AssignmentUserView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
