package com.mobileMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MobileMessaging
 */
@WebServlet("/MobileMessaging")
public class MobileMessaging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MobileMessaging() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		     //String num=request.getParameter("number");
		    // Long number=Long.parseLong(num);
		     Long number=8500942552L;
		    // String message=request.getParameter("message");
		     String message="Ur transaction id is 234 and Hope u to see u soon";
		     
		    URL oracle = new URL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:12345678&senderID=WEBSMS&receipientno="+number+"&dcs=0&msgtxt="+message+"&state=4");
	        URLConnection yc = oracle.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    yc.getInputStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) 
	            out.println(inputLine);
	        in.close();
	        RequestDispatcher rd=request.getRequestDispatcher("test.jsp");
	        rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
