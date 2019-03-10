<%-- 
    Document   : main
    Created on : Feb 20, 2019, 11:11:21 AM
    Author     : nguye
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">

            function changeFunc() {
                var persontype = document.getElementById("persontype");
                var selectedValue = persontype.options[persontype.selectedIndex].value;
                if (selectedValue === "1")
                {
                    document.getElementById("salary").style.display = 'none';
                    document.getElementById("percent").style.display = 'none';
                    document.getElementById("percenttag").style.display = 'none';
                } else

                {
                    document.getElementById("salary").style.display = 'initial';
                    document.getElementById("percent").style.display = 'initial';
                    document.getElementById("percenttag").style.display = 'initial';
                }
                if (selectedValue === "3")
                {
                    document.getElementById("membercount").style.display = 'initial';
                    document.getElementById("homeid").style.display = 'initial';
                    document.getElementById("bossname").style.display = 'initial';
                    document.getElementById("address").style.display = 'initial';
                } else
                {
                    document.getElementById("membercount").style.display = 'none';
                    document.getElementById("bossname").style.display = 'none';
                    document.getElementById("address").style.display = 'none';
                    document.getElementById("homeid").style.display = 'none';
                }
            }

        </script>
    </head>
    <body>
        <%
            User user = new User();

            user = (User) session.getAttribute("user");


        %>
        <jsp:include page="header.jsp"></jsp:include>
    <center>
        <form method="POST" action="CacuServlet">
            <a>Đối tượng tính theo cách đặc biệt</a>
            <select name="persontype" id = "persontype" onchange="changeFunc();" >
                <option value="0">Diện bình thường</option>
                <option value="1">Sinh Viên</option>
                <option value="2">Người lao động bị tạm giam</option>
                <option value="3">Tính bảo hiểm y tế theo hộ gia đình</option>

            </select>
            <br><br>
            <input type="text" placeholder="  Mã Bảo Hiểm Y Tế" name="bhytID" id="bhytID" class="custom-size" >
            <br><br>
            <input type="text" placeholder="  Họ Và Tên" name="name" id="name" class="custom-size">
            <br><br>
            <input type="text" placeholder="  CMND" name="cmnd" id="cmnd" class="custom-size">
            <br><br>



            <input type="text" placeholder="  Lương Cơ Bản" name="salary" id="salary" class="custom-size">
            <br><br>
            <input type="text" style = "display:none"placeholder="  Số Thành viên trong gia đình" name="membercount" id="membercount" class="custom-size">
            <br><br>
            <input type="text" style = "display:none"placeholder="  Họ và tên chủ hộ" name="bossname" id="bossname" class="custom-size">
            <br><br>
            <input type="text" style = "display:none"placeholder="  Số sổ hộ khẩu" name="homeid" id="homeid" class="custom-size">
            <br><br>
            <input type="text" style = "display:none"placeholder="  Địa chỉ" name="address" id="address" class="custom-size">

            <br><br>
            <a id="percenttag">Diện dược hỗ trợ</a>
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
