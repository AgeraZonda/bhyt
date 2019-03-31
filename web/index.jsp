<%-- 
    Document   : index
    Created on : Oct 17, 2018, 4:33:06 PM
    Author     : User
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>JSP Page</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script src="js/jquery-3.2.1.min.js"></script>
    </head>
    <body>    
            <!-- <jsp:include page="header.jsp"></jsp:include> -->
        <%
            User user = null;
            if (session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
        %>
            <div class="header-page--02">
                <jsp:include page="header.jsp"></jsp:include>
            </div>
        <%
            } else {
        %>        
            <%--<jsp:include page="login.jsp"></jsp:include>--%>
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="signup.jsp"></jsp:include>
        <% }
            ArrayList<User> listMember = new ArrayList<User>();
        %>
        <br><br><br><br>
        <% if (user != null) {%>  


        <br><br> 

        <div class="cacufee">
            <div class="cacufee__content">
            <li>
                <a href="ttcn.jsp?userID=<%=user.getUserID()%>">Khai Báo Thông Tin</a>
            </li>
            <li>
                <a href="main.jsp?userID=<%=user.getUserID()%>">
                    Tính bhyt
                </a>
            </li>
            </div>
        </div>
        <% }%>

    </body>
</html>
