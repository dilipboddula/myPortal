<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <body> 
<%! 
 public void callURL(String strURL){ 
 System.out.println(" URL is :"+strURL); 
 try{ 
 java.net.URL obj = new java.net.URL(strURL); 
 HttpURLConnection httpReq = (HttpURLConnection)obj.openConnection(); 
 httpReq.setDoOutput(true); 
 httpReq.setInstanceFollowRedirects(true); 
 httpReq.setRequestMethod("GET"); 
 int iStatus = httpReq.getResponseCode(); 
 System.out.println("Status is:"+iStatus); 
 } catch (MalformedURLException ex) { 
 ex.printStackTrace(); 
 }catch (IOException ex) { 
 ex.printStackTrace(); 
 }catch(Exception e){ 
 e.printStackTrace(); 
 } 
 } 
 %> 

 <h2>(message)</h2> 
 
<%callURL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=(dilipboddula@gmail.com:12345678)
&senderID=(SA)&receipientno=(DA&msgtype=7&dcs=240&msgtxt=(message)&state=(1,2,3,4)”);
// 
 %> 
</body>
</html>