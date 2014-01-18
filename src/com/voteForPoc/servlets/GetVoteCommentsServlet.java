package com.voteForPoc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.awards.Awards;
import com.model.ModelDAO;
import com.test.HibernateUtil;
import com.voteForPoc.Votes;
import com.voteForPoc.VotesDAO;
import com.voteForPoc.VotesImpl;

/**
 * Servlet implementation class GetVoteComments
 */
@WebServlet("/GetVoteCommentsServlet")
public class GetVoteCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVoteCommentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nomineeIdDummy=request.getParameter("r1");
		 int nomineeId=Integer.parseInt(nomineeIdDummy);
		System.out.println(nomineeId);
		HttpSession session=request.getSession();
    	int scopeId=(int) session.getAttribute("myScopeId");
    	int voteCompId=1;
    	VotesDAO ref=new VotesImpl();
    	ArrayList<Votes> al=ref.getCommentsStastics(scopeId, nomineeId, voteCompId);
		
			request.setAttribute("myVoteComments", al);
			//request.setAttribute("myNomineeName",nomineeName);
		    RequestDispatcher rd=request.getRequestDispatcher("getVoteComments.jsp");
		    rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
