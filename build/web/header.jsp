  
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/header.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        <div class="header">			
            <div class="header-logo">
                <h1>Tính phí bảo hiểm y tế</h1>
            </div>

            <% 
            User user = new User();

            
            if(session.getAttribute("user") != null)
            {
                user = (User) session.getAttribute("user");
                String ttcnUrl = "ttcn.jsp?userID=" + user.getUserID();
            %>
                <div class="header-content">

                    <div class="header-menu">
                        <ul style="    list-style-type: none;">
                            <%
                                if(user.getAdmin() == 1 ){
                            %>
                            <li><a href="admin.jsp">ADMIN </a></li>
                            <% } %>
                            
                            <li><a href="index.jsp?userID=<%=user.getUserID()%>" style="text-transform: uppercase;">Trang Chủ</a></li>
                                            
                            <li>
                                <form action="UserServlet" method="post">
                                    <input type="hidden" value="logout" name="command">
                                    <button type="submit" value="logout" class="btn-logout"><b>Đăng Xuất</b></button>
                                </form>
                            </li>	
                        </ul>
                    </div>
                </div>   
            <% } else { %>      
            <center><jsp:include page="login.jsp"></jsp:include></center>
            
            <% } %>
        </div>
    </body>
</html>
