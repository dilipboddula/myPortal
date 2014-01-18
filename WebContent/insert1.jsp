<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.net.Authenticator,java.net.PasswordAuthentication,java.io.BufferedReader,java.net.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/sapient"
user="root" password="root"/>
<sql:update dataSource="${mydatabase}" var="result">
insert into fines(name,amount,date,comment,fineType) values(?,?,?,?,?);
 			<sql:param value="${param.name}" />
            <sql:param value="${param.amount}" />
             <sql:param value="${param.date}" />
            <sql:param value="${param.comment}" />
            <sql:param value="${param.fineType}" />
</sql:update>
<c:if test="${result>=1}">
    <h3> <font size="5" color='green'> Congratulations ! Data inserted
            successfully.Insert another!</font>
     </h3>
</c:if>
<c:if test="${result<1}">
     <font size="5" color='green'> Error in insertion.</font>
</c:if>

<sql:query dataSource="${mydatabase}" var="result1">
SELECT * from SapientUsers where userName='${param.name}';
</sql:query>
<c:forEach var="row1" items="${result1.rows}">
	
	<c:out value="${row1.userPhone}"/>
	<%String phone= "${row1.userPhone}";
	System.out.println(phone);
	String message="'Hello '+${param.name}+' we have recieved ur payment '+${param.amount}+'on '+${param.date}";
	System.out.println(message);
	%>
</c:forEach>
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
 
 <h2><c:out value="${message}"/></h2> 
 
<%
/* long num=9535975594l;
String msg="pp";
callURL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:12345678&senderID=TEST SMS&receipientno=9535975594&dcs=0&msgtxt=hello dilip&state=4");
//  */
messaging();
 %> 


</body>
</html>