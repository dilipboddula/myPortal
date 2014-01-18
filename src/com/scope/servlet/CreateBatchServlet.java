package com.scope.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scope.BatchDetails;
import com.scope.BatchDetailsDAO;
import com.scope.BatchDetailsImpl;

/**
 * Servlet implementation class CreateBatchServlet
 */
@WebServlet("/CreateBatchServlet")
public class CreateBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        String location=request.getParameter("location");
		String batch=request.getParameter("batch");				
		String cycleDummy =request.getParameter("cycle");
		int cycle= Integer.parseInt(cycleDummy);
		
		String stageDummy =request.getParameter("stage");
		int stage=Integer.parseInt(stageDummy);		
		BatchDetails b=new BatchDetails();
		b.setBatch(batch);
		b.setCycle(cycle);
		b.setLocation(location);
		b.setUpdateId(0);
		b.setStage(stage);
		
		 BatchDetailsDAO ref=new BatchDetailsImpl();
	        int id=ref.addBatch(b);
	        if (id>0)
	        {
	        	out.println("<h2>Batch Has been successfully Created!! reference scope id is "+id+"</h2>");
	             
	        }else{
	        	out.println("<h2>Error in insertion</h2>");
	        	
	        }
	        return;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
