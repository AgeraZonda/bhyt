<%-- 
    Document   : details
    Created on : Feb 20, 2019, 11:40:04 AM
    Author     : nguye
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% User u = new User();%>

    <body>
        <h3>Họ Và Tên: <%=u.getUsername()%></h3>
    </body>
</html>
