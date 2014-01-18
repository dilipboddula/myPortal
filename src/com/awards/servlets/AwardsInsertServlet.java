package com.awards.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.awards.AwardsImpl;
import com.awards.AwardsDAO;


/**
 * Servlet implementation class AwardsInsertServlet
 */
@WebServlet("/AwardsInsertServlet")
public class AwardsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AwardsInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter ps=response.getWriter();
		response.setContentType("text/html");
		String[] id=request.getParameterValues("nameSelectContainer");
		int[] nomineeArray=new int[6];		
		for (int i=0;i<6;i++)
		{
			nomineeArray[i]=Integer.parseInt(id[i]);
		}
		/*for (int s : nomineeArray) {
			System.out.println(s);
		}*/
		String[] reasonArray=new String[6];
		reasonArray[0]=request.getParameter("comCreativity");
		reasonArray[1]=request.getParameter("comLeadership");
		reasonArray[2]=request.getParameter("comOpenness");
		reasonArray[3]=request.getParameter("comClientFocusedDelivery");
		reasonArray[4]=request.getParameter("comRelationship");
		reasonArray[5]=request.getParameter("comPeopleGrowth");
		
		String[] impactArray=new String[6];
		impactArray[0]=request.getParameter("impactCreativity");
		impactArray[1]=request.getParameter("impactLeadership");
		impactArray[2]=request.getParameter("impactOpenness");
		impactArray[3]=request.getParameter("impactClientFocusedDelivery");
		impactArray[4]=request.getParameter("impactRelationship");
		impactArray[5]=request.getParameter("impactPeopleGrowth");
		/*for (String s : reasonArray) {
			System.out.println(s);
		}*/
		HttpSession session=request.getSession();
		int nominatorId=(int) session.getAttribute("myUserId");
		/*int nominatorId=Integer.parseInt(a);*/
		int scopeId=(int) session.getAttribute("myScopeId");
		System.out.println("nominator Id "+nominatorId );
		
		//checking duplicate entry
		AwardsDAO ref=new AwardsImpl();
		boolean result1=ref.checkAwardsDuplicate(nominatorId);
		if (result1==true){
			ps.println("<h2>Duplicate Entry !! Response not recorded</h2>");
			return;
		}else{
		//calling interfacce
		boolean result=ref.addNominees(nominatorId, nomineeArray, reasonArray,scopeId,impactArray);
		/*System.out.println("my id is "+nomineeId);*/
		
		if (result){
			ps.println("<h2> your response added successfully. Thank you!</h2>");
			return;
		}else{
			ps.println("<h2> Error in insertion !. We will get back to u soon! Stay Tuned !</h2>");
			return;
		}
		
		
		}
	}

}
