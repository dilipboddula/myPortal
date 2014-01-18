package com.admin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.Admin;
import com.admin.AdminDAO;
import com.admin.AdminImpl;

/**
 * Servlet implementation class createAdminServlet
 */
@WebServlet("/CreateAdminServlet")
public class CreateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        System.out.println("in servlet");
        String manDiffer=request.getParameter("manDiffer");
        int scopeId;
        if (manDiffer.equals("abc")){
        	String batchDetails=request.getParameter("batchDetails");
        	scopeId=Integer.parseInt(batchDetails);
        	System.out.println("scope id of manager is " +scopeId);
        	
        }else{
        	HttpSession session=request.getSession();
        	scopeId=(int) session.getAttribute("myScopeId");
        }
        String adminRole=request.getParameter("adminRole");
        String adminUserName=request.getParameter("adminUserName");
        System.out.println("admin User name is "+adminUserName);
        String adminPassword=adminRole.concat("#");
        System.out.println("admin password is "+adminPassword);
        
        Admin a=new Admin();
        a.setAdminPassword(adminPassword);
        a.setAdminRole(adminRole);
        a.setAdminUserName(adminUserName);
        a.setScopeId(scopeId);
        a.setUploadTrigger(0);
        
       AdminDAO ref=new AdminImpl();
       int adminId=ref.addAdmin(a);
       if (adminId==0){
			out.println("<h2> Error in insertion. we will get back to u soon. Thank u</h2>");
			return;
		}else{
		out.println("<h2>"+adminRole+" created successFull. reference id "+adminId+"</h2>");	
		out.println("Default "+adminRole+" Login Id is "+adminUserName);
		out.println("Deffault "+adminRole+" password is "+adminPassword);
		out.println("Ask the "+adminRole+" to change credentials after first login ");	
		/*out.println("Notify "+adminRole+" ?  <a href='#'><img id='emailIconId' src='icons/email.png' onclick='location.href = mailto:'></a> ");	
		*/
		out.println("Notify  "+adminRole+"  ");
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
