<%-- 
    Document   : main
    Created on : Feb 20, 2019, 11:11:21 AM
    Author     : nguye
--%>

<%@page import="java.util.ArrayList"%>
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
                var x = document.getElementById("myDIV");
                if (selectedValue === "3")
                {
                    document.getElementById("homeid").style.display = 'initial';
                    document.getElementById("bossname").style.display = 'initial';
                    document.getElementById("Searchfamily").style.display = 'initial';
                    document.getElementById("membercount").style.display = 'initial';
                    document.getElementById("searchtable").style.display = 'initial';
                    x.style.display = "block";
                } else
                {
                    document.getElementById("bossname").style.display = 'none';
                    document.getElementById("homeid").style.display = 'none';
                    document.getElementById("Searchfamily").style.display = 'none';
                    document.getElementById("membercount").style.display = 'none';
                    document.getElementById("searchtable").style.display = 'none';
                    x.style.display = "none";
                }
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

            }

        </script>
    </head>
    <body>
        <%
            User user = new User();
            ArrayList<User> familyMember = new ArrayList<User>();
            if (session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
            }

            if (session.getAttribute("listmember") != null) {

                familyMember = (ArrayList<User>) session.getAttribute("listmember");
            }


        %>
        <jsp:include page="header.jsp"></jsp:include>
        <center>





            <br><br>


            <br><br>
            <form action="CacuServlet" id = "Caculatorfamily"  method="POST" class="form-cacu" id="cacu">
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
                <input type="text" placeholder="  Lương Cơ Bản" name="salary" id="salary" class="custom-size">
                <h5 style="color: red"><%= request.getAttribute("error2") != null ? request.getAttribute("error2") : " "%></h5>
            <input type="text" style = "display:none"placeholder="  Họ và tên chủ hộ" name="bossname" id="bossname" class="custom-size">
            <br><br>
            <input type="text" style = "display:none"placeholder="  Số sổ hộ khẩu" name="homeid" id="homeid" class="custom-size">
            <br><br>
            <input type="text" style = "display:none"placeholder="  Số thành viên trong gia đình" name="membercount" id="membercount" class="custom-size">
            
            </table>
            </div>




            <br><br>
            <a id="percenttag">Diện dược hỗ trợ</a>
            <select name="percent" id = "percent" >
                <option value="1">100%</option>
                <option value="2">70%</option>
                <option value="3">30%</option>
                <option value="4">0%</option>
            </select>
            <br><br>
            <input type="submit" value="Tính" class="custom-inp">
        </form>
            <div id="myDIV">
                <a>Nhập cmnd các thành viên trong gia đình (Để lưu thông tin các thành viên trong gia đình)</a> <br>
            <form action="SearchServlet" id = "Searchfamily"  method="POST" class="form-search" >
                <input type="text" name="content_search" placeholder="  Write a cmnd..." class="add-comment">
                <input type="hidden" value="<%=user.getcmnd()%>" name="userID">
                <input type="submit" value="Tìm kiếm" class="custom-inp">
            </form>
            <table>
                <tr>
                    <th>CMND</th>
                    <th>Họ Tên</th>
                    <th>Ngày Sinh</th>
                </tr>
                <% for (int i = 0; i < familyMember.size(); i++) {

                %>


                <tr>
                    <td><%=familyMember.get(i).getcmnd()%></td>
                    <td><%=familyMember.get(i).getUsername()%></td>
                    <td><%=familyMember.get(i).getDob()%></td>

                </tr>
                <%
                    }

                %>
    </center>

</body>

</html>
