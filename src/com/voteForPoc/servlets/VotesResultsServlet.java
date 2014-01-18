package com.voteForPoc.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.test.HibernateUtil;
import com.voteForPoc.VotesDAO;
import com.voteForPoc.VotesImpl;

/**
 * Servlet implementation class VotesResults
 */
@WebServlet("/VotesResultsServlet")
public class VotesResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotesResultsServlet() {
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
    	VotesDAO ref=new VotesImpl();
    	List result=ref.getAllVotesStastics(scopeId, voteCompId);
    	
		request.setAttribute("myVotesForPoc", result);
		RequestDispatcher rd= request.getRequestDispatcher("VoteForPocResults.jsp");
		/*RequestDispatcher rd= request.getRequestDispatcher("test.jsp");*/
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
