package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.assignment.Assignment;
import com.assignment.AssignmentImpl;
import com.assignment.AssignmentDAO;


/**
* Servlet implementation class AssignmentServlet
*/
@WebServlet("/InsertAssignmentServlet")
public class InsertAssignmentServlet extends HttpServlet {
       private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

       /**
       * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
       */
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              PrintWriter pw=response.getWriter();
              response.setContentType("text/html");
              String assignment=request.getParameter("assignment");
              System.out.println("assignment is"+assignment);
              String date1=request.getParameter("date");
              
              HttpSession session=request.getSession();
          	int scopeId=(int) session.getAttribute("myScopeId");
            /*  DateFormat df=new SimpleDateFormat("yy-mm-dd");*/
              SimpleDateFormat format2 = new SimpleDateFormat("yy-mm-dd");
              java.util.Date date=null;
              try {
                     date=format2.parse(date1);
              } catch (ParseException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
               AssignmentDAO ref=new AssignmentImpl();
               boolean result;
               Assignment a=new Assignment();
               a.setAssignment(assignment);
               a.setDate(date);
               a.setScopeId(scopeId);
               result=ref.addAssignment(a);
               if (result){
            	   pw.println("Assignment has been successfully uploaded");
            	   return;
               }else{
            	   pw.println("Error in Assignment uploading");
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
