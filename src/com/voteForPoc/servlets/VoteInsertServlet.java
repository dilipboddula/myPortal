package com.voteForPoc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.Assignment;
import com.assignment.AssignmentDAO;
import com.assignment.AssignmentImpl;
import com.voteForPoc.Votes;
import com.voteForPoc.VotesDAO;
import com.voteForPoc.VotesImpl;

/**
 * Servlet implementation class VoteInsertServlet
 */
@WebServlet("/VoteInsertServlet")
public class VoteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteInsertServlet() {
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
    	int nominatorId=(int) session.getAttribute("myUserId");
    	int voteCompId=1;
    	VotesDAO ref=new VotesImpl();
    	boolean duplicate=ref.checkDuplicateVoteEntry(scopeId, nominatorId, voteCompId);
    	if (duplicate==true){
			pw.println("<h2>Duplicate Entry !! Response not recorded</h2>");
			return;
		}else{      
        
        String nomineeIdDummy=request.getParameter("nameSelectContainer");
        int nomineeId=Integer.parseInt(nomineeIdDummy);
        
        System.out.println("nominator Id"+nomineeId);
        String comment=request.getParameter("comment");
        
        
    	
    	String nominatorName=(String) session.getAttribute("myUserName");
        
         
         Votes v=new Votes();
         v.setComment(comment);
         v.setNominatorId(nominatorId);
         v.setNominatorName(nominatorName);
         v.setNomineeId(nomineeId);
         v.setScopeId(scopeId);
         v.setVoteCompId(voteCompId);
        int result= ref.insertVote(v);
         if (result >0){
      	   pw.println("Your Vote has been successfully recoreded.Thank you");
      	   return;
         }
         else{
      	   pw.println("Error in recording your Vote");
      	   return;
         }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
