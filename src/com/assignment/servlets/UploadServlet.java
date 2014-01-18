package com.assignment.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.assignment.AssignmentImpl;
import com.assignment.AssignmentDAO;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 1;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
       // factory.setSizeThreshold(MAX_MEMORY_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
      // String uploadFolder = getServletContext().getRealPath("")
       //         + File.separator + DATA_DIRECTORY;
        String uploadFolder="C:\\Users\\dboddu\\JEE\\Sapient\\WebContent\\data";
        ServletFileUpload upload = new ServletFileUpload(factory);
        //upload.setSizeMax(MAX_REQUEST_SIZE);
        String partnerName=null;
        String projectDescription=null;
        String projectName=null;
        String fileName=null;
        String url=null;
      	

        try {
            // Parse the request
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    fileName = new File(item.getName()).getName();
                	//String fileName =fname;
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    System.out.println(fileName);

                    // saves the file to upload directory
                    item.write(uploadedFile);
                }
                switch (item.getFieldName()) {

                case "nameSelectContainer":
                	partnerName=item.getString();
                	break;
                case "description":
                	projectDescription=item.getString();
                	break;
                case "projectName":
                	 projectName=item.getString();
                	break;
                case "url":
               	 url=item.getString();
               	break;
                }


            }

            // displays done.jsp page after upload finished
           /* getServletContext().getRequestDispatcher("/done.jsp").forward(
                    request, response);*/

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
        
        System.out.println(projectName);
        System.out.println(partnerName);
        HttpSession session =request.getSession();
        String a=(String) session.getAttribute("assignmentId");
        int member1Id=(int) session.getAttribute("myUserId");
        int scopeId=(int) session.getAttribute("myScopeId");
        //int member1Id=Integer.parseInt(b);
        int assignmentId=Integer.parseInt(a);
        System.out.println("assignmentid"+assignmentId);
        System.out.println("member1Id"+member1Id);
        int member2Id=0;
        if(!partnerName.equals("temp"))
        {member2Id=Integer.parseInt(partnerName);}
        
        
        AssignmentDAO ref=new AssignmentImpl();
        Integer id=ref.submitAssigment(scopeId,assignmentId, member1Id, member2Id, projectName, fileName, projectDescription,url);
        PrintWriter out=response.getWriter();
        if (id>0)
        {
        	out.println("<h2>Your assignment has been successfully uploaded. reference id is UP235"+id+"</h2>");
             
        }else{
        	out.println("<h2>Error in insertion</h2>");
        	
        }
        return;
  }
    
}