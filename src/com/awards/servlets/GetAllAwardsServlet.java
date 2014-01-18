package com.awards.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.naming.resources.Resource;

import com.awards.AwardsImpl;
import com.awards.AwardsDAO;

/**
 * Servlet implementation class GetAllAwardsServlet
 */
@WebServlet("/GetAllAwardsServlet")
public class GetAllAwardsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllAwardsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
    	int scopeId=(int) session.getAttribute("myScopeId");
    	int scopeDummy=0;
    	if (scopeId==0){
    		String scope=request.getParameter("batchDetails");
    		scopeDummy=Integer.parseInt(scope);
    		session.setAttribute("myScopeId", scopeDummy);
    		scopeId=scopeDummy;
    		
    	}
		AwardsDAO ref=new AwardsImpl();
		List al=ref.getTop5Creativity(scopeId);
		request.setAttribute("myCreativityList", al);
		/*ArrayList<Integer> stats=ref.getAwardStats(scopeId); 
		request.setAttribute("myStats", al);*/
		//RequestDispatcher rd=request.getRequestDispatcher("AdminAwardsStastics.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("AdminAwardsStastics.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
