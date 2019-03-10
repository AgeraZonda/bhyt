<%-- 
    Document   : index
    Created on : Oct 17, 2018, 4:33:06 PM
    Author     : User
--%>


<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>    
        <jsp:include page="header.jsp"></jsp:include>
        <%
            User user = null;
            if (session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
            } else {
        %>        
        <%--<jsp:include page="login.jsp"></jsp:include>--%>
        <jsp:include page="signup.jsp"></jsp:include>
        <% } %>
        <br><br><br><br>
        <% if (user != null) {%>  


        <br><br> 

        <div class="cacufee">
            <center>
                <li><a href="ttcn.jsp?userID=<%=user.getUserID()%>" style=" padding-left: 5px;padding-right: 20px;">Khai Báo Thông Tin</a></li>
                <li><a href="main.jsp?userID=<%=user.getUserID()%>" style="text-transform: uppercase;"><b>Tính bhyt</b></a></li>
            </center>

        </div>
        <% }%>

    </body>
</html>
