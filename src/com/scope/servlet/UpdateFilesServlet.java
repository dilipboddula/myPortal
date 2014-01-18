package com.scope.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scope.BatchDetailsDAO;
import com.scope.BatchDetailsImpl;

/**
 * Servlet implementation class UpdateFilesServlet
 */
@WebServlet("/UpdateFilesServlet")
public class UpdateFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFilesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
        String scopeIdDummy=request.getParameter("r1");
        int scopeId=Integer.parseInt(scopeIdDummy);
        System.out.println("Scope id in Update File Servlet is"+scopeId);
        BatchDetailsDAO ref= new BatchDetailsImpl();
        boolean result=ref.updateFiles(scopeId);
        System.out.println("result in updatefileservlet is "+result);
        if (result){
     	   pw.println("Updated");
     	   return;
        }else{
     	   pw.println("Error");
     	   return;
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
