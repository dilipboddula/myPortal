<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

    	try{
		String adminRole=(String)session.getAttribute("myRole");
        System.out.println("an"+adminRole);
        if(adminRole.equals("Trainer"))
    		response.sendRedirect("trainerView.jsp");
        else if(adminRole.equals("Manager"))
    		response.sendRedirect("managerView.jsp");
        else if(adminRole.equals("POC"))
   		response.sendRedirect("finePortal.jsp");
        else if(adminRole.equals("supervisor"))
      		response.sendRedirect("supervisorView.jsp");
        else if(adminRole.equals("Admin"))
      		response.sendRedirect("adminView.jsp");
        else response.sendRedirect("AuthAvoid.jsp");
    	}

          catch(Exception e)
          {
        	  response.sendRedirect("AuthAvoid.jsp");
          }
   %>
</body>
</html>