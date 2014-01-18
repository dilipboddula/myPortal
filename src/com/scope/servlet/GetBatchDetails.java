package com.scope.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.scope.BatchDetails;
import com.scope.BatchDetailsDAO;
import com.scope.BatchDetailsImpl;

/**
 * Servlet implementation class GetBatchDetails
 */
@WebServlet("/GetBatchDetails")
public class GetBatchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBatchDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		BatchDetailsDAO w=new BatchDetailsImpl();
		ArrayList<BatchDetails> al=new ArrayList<BatchDetails>();
		al=w.getSubmittedFiles();		
		request.setAttribute("myBatchDetails",al);
		RequestDispatcher rd=request.getRequestDispatcher("supCreateManager.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
