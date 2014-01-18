package com.awards.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.awards.Awards;
import com.awards.AwardsImpl;
import com.awards.AwardsDAO;

/**
 * Servlet implementation class GetComments
 */
@WebServlet("/GetCommentsServlet")
public class GetCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCommentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("nomineeId");
		String b=request.getParameter("coreValueId");
		
		int nomineeId=Integer.parseInt(a);
		int coreValueId=Integer.parseInt(b);
		AwardsDAO ref=new AwardsImpl();
		ArrayList<Awards> al=ref.getComments(nomineeId, coreValueId);
		request.setAttribute("myComments", al);
		//request.setAttribute("myNomineeName",nomineeName);
	    RequestDispatcher rd=request.getRequestDispatcher("getComments.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
