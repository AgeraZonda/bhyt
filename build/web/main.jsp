<%-- 
    Document   : main
    Created on : Feb 20, 2019, 11:11:21 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form method="POST" action="CacuServlet">
            <input type="text" placeholder="  Mã Bảo Hiểm Y Tế" name="bhytID" id="bhytID" class="custom-size" >
            <br><br>
            <input type="text" placeholder="  Họ Và Tên" name="name" id="name" class="custom-size">
            <br><br>
            <input type="text" placeholder="  CMND" name="cmnd" id="cmnd" class="custom-size">
            <br><br>
            <input type="text" placeholder="  Lương Cơ Bản" name="salary" id="salary" class="custom-size">
            <br><br>
            <a>Diện dược hỗ trợ</a>
            <select name="percent" id = "percent" >
                <option value="1">100%</option>
                <option value="2">70%</option>
                <option value="3">30%</option>
                <option value="4">0%</option>
            </select>
            <br><br>
            <input type="submit" value="Kiểm Tra Phí" class="custom-inp">
        </form>
    </center>

</body>
</html>
