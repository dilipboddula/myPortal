package com.voteForPoc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.AdminDAO;
import com.admin.AdminImpl;
import com.voteForPoc.VotesDAO;
import com.voteForPoc.VotesImpl;

/**
 * Servlet implementation class NominatePocServlet
 */
@WebServlet("/NominatePocServlet")
public class NominatePocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NominatePocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
        HttpSession session=request.getSession();
    	int scopeId=(int) session.getAttribute("myScopeId");
    	int voteCompId=1;
    	String nomineeIdDummy=request.getParameter("r1");
		 int nomineeId=Integer.parseInt(nomineeIdDummy);
    	AdminDAO ref=new AdminImpl();
    	int id=ref.addPoc(scopeId, nomineeId);
    	if (id>0){
     	   pw.println("<h1>Nomination has been succesfull and it is notfied to all the Participants</h1>");
     	   return;
        }else{
     	   pw.println("Error in Nomination");
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
