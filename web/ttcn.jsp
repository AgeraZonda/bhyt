<%-- 
    Document   : ttcn
    Created on : Nov 26, 2018, 9:14:33 PM
    Author     : Han
--%>



<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/ttcn.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            User user = new User();

            user = (User) session.getAttribute("user");

            
        %>
        <br><br><br><br>
    <center>
        <h1>Information</h1> <br>
        <h2><%= user.getUsername()%></h2>
        <br>
        <form method="POST" action="UserServlet">
<!--                        <input type="hidden" value="<%= user.getUserID()%>" name="userID" id="userID">-->

            
            <p style="margin-right: 250px; margin-bottom: 8px;" >CMND</p>
            <input type="text" value="<%=user.getcmnd()%>" name="cmnd" id="cmnd" class="custom-size">
            <p style="margin-right: 220px; margin-bottom: 8px;" >Full Name</p>
            <span id="user-result"></span>
            <input type="text" value="<%=user.getUsername()%>" name="name" id="name" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Ngày Sinh</p>
            <input type="text" value="<%=user.getDob()%>" name="dob" id="dob" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Dân Tộc</p>
            <input type="text" value="<%=user.getDantoc()%>" name="dantoc" id="dantoc" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Họ tên người dám hộ(đối với trẻ em dưới 6 tuổi)</p>
            <input type="text" value="<%=user.getHotennguoidamho()%>" name="ngdamho" id="ngdamho" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Giới Tính</p>
            <input type="text" value="<%=user.getGioitinh()%>" name="gioitinh" id="gioitinh" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Quê Quán</p>
            <input type="text" value="<%=user.getQuequan()%>" name="quequan" id="quequan" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Mã Số BHXH(đã cấp)</p>
            <input type="text" value="<%=user.getBhxh_id()%>" name="bhxh" id="bhxh" class="custom-size">
            <p style="margin-right: 250px; margin-bottom: 8px;" >Mã Số Hộ Gia Đình(đã cấp)</p>
            <input type="text" value="<%=user.getHogiadinh_id()%>" name="hogiadinh" id="hogiadinh" class="custom-size">
            

            
            <!--                        <br><br>-->
            <!--                        <input type="password" placeholder="  OldPassword" name="opass" id="pass" class="custom-size">
                                    <br><br>
                                    <input type="password" placeholder="  Password" name="pass" id="pass" class="custom-size">
                                    <br><br>
                                    <input type="password" placeholder="Confirm Password" name="copass" id="pass" class="custom-size">
                                    <br><br>-->
            <br><br>
            <input type="hidden" value="update" name="command">
            <input type="submit" value="Update" class="custom-inp">
        </form>
            <br>
            <p><a href="changePass.jsp">Đổi mật khẩu</a></p>
    </center>
</body>
</html>
