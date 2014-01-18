package com.scope.servlet;

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

import com.scope.BatchDetails;
import com.scope.BatchDetailsDAO;
import com.scope.BatchDetailsImpl;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/batchUploadServlet")
public class batchUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 1;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
       
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
        String uploadFolder="C:\\Users\\dboddu\\Hibernate\\TrainingPortal\\WebContent\\excelfiles";
        ServletFileUpload upload = new ServletFileUpload(factory);
        //upload.setSizeMax(MAX_REQUEST_SIZE);
        String fileName=null;
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
                


            }

            // displays done.jsp page after upload finished
           /* getServletContext().getRequestDispatcher("/done.jsp").forward(
                    request, response);*/

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
        
        HttpSession session=request.getSession();
    	int scopeId=(int) session.getAttribute("myScopeId");
    	//int scopeId=Integer.parseInt(scopeIdDummy);
        BatchDetails b=new BatchDetails();
      
        b.setFileName(fileName);
     
        BatchDetailsDAO ref=new BatchDetailsImpl();
        boolean result=ref.insertFileName(scopeId, fileName);
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        if (result)
        {
        	out.println("<h2>File has been successfully uploaded .The Detials will be uploaded into System on admin approval and u will be notified soon.Thanking u</h2>");
             
        }else{
        	out.println("<h2>Error in insertion</h2>");
        	
        }
        return;
  }
    
}