<%-- 
    Document   : login
    Created on : Oct 17, 2018, 5:12:50 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
        <div class="login">
            <form action="UserServlet" method="POST" class="login-form">
                <input type="text" name="login-cmnd" id="login-cmnd" placeholder="  CMND" class="custom-login">
                <input type="password" name="login-pass" id="login-pass" placeholder="  Mật khẩu" class="custom-login">
                <input type="hidden" value="login" name="command">
                <input type="submit" value="Đăng Nhập" id="submit-btn" class="btn-login button-01">
            </form>
            <p>Không có tải khoản ? <a id="open-modal-signup" href="signup.jsp">Đăng Ký</a></p>
        </div>
    </body>
</html>
