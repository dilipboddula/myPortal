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
 * Servlet implementation class GetSubmitAssignmentServlet
 */
@WebServlet("/GetSubmittedFilesServlet")
public class GetSubmittedFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubmittedFilesServlet() {
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
		al=w.getSubmittedFiles(0);
		request.setAttribute("mySubmittedFiles", al);
		RequestDispatcher rd=request.getRequestDispatcher("adminSubmittedFiles.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
