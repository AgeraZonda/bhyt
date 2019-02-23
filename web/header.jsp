  
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        <div class="header">			
            <div class="header-logo">
                <center><h1>Tính phí bảo hiểm y tế</h1></center>
            </div>

            <% 
            User user = new User();

            
            if(session.getAttribute("user") != null)
            {
                user = (User) session.getAttribute("user");
                String ttcnUrl = "ttcn.jsp?userID=" + user.getUserID();
            %>   
            <center>
                <div class="header-content">


                    <div class="header-menu">
                        <ul style="    list-style-type: none;">
                            <%
                                if(user.getAdmin() == 1 ){
                            %>
                            <li><a href="admin.jsp"><b>ADMIN</b> </a></li>
                            <% } %>
                            
                            <li><a href="home.jsp?userID=<%=user.getUserID()%>" style="text-transform: uppercase;"><b><%= user.getUsername() %></b></a></li>
                                            <li><a href="<%=ttcnUrl%>" style=" padding-left: 5px;padding-right: 20px;">Khai Báo Thông Tin</a></li>
                            <li>
                                <form action="UserServlet" method="post">
                                    <input type="hidden" value="logout" name="command">
                                    <button type="submit" value="logout" class="btn-logout"><b>LOG OUT</b></button>
                                </form>
                            </li>	
                        </ul>
                    </div>
                </div>      
            </center>
                
            <% } else { %>      
            <center><jsp:include page="login.jsp"></jsp:include></center>
            
            <% } %>
        </div>
    </body>
</html>
