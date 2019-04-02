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
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript">

            function changeFunc() {
                var persontype = document.getElementById("persontype");
                var selectedValue = persontype.options[persontype.selectedIndex].value
                if (selectedValue === "3")
                {
                    document.getElementById("showIfSelectedEqual3").style.display = 'block';

                } else
                {
                    document.getElementById("showIfSelectedEqual3").style.display = 'none';
                }
                if (selectedValue === "1")
                {
                    document.getElementById("showIfSelectdEqual1").style.display = 'none';
                } else
                {
                    document.getElementById("showIfSelectdEqual1").style.display = 'block';
                }

            }

        </script>
    </head>
    <body>
        <%
            User user = new User();
            ArrayList<User> familyMember = new ArrayList<User>();
            if (session.getAttribute("user") == null) {

        %>
    <center><h1 style="padding-top: 200px" class="title">You need to login</h1></center>
        

        <%                } else {
            user = (User) session.getAttribute("user");

            if (session.getAttribute("listmember") != null) {

                familyMember = (ArrayList<User>) session.getAttribute("listmember");
            }


        %>
        <div class="header-page--02">
            <jsp:include page="header.jsp"></jsp:include>
            </div>

            <div class="calculate__page">
                <div class="grid">
                    <div class="grid-item">
                        <div class="grid-item-content">
                            <h3 class="title">Tính phí bảo hiểm y tế</h3>
                            <form action="CacuServlet" id="Caculatorfamily"  method="POST" class="form-cacu">
                                <div class="input-item">
                                    <span>Đối tượng tính theo cách đặc biệt</span>
                                    <select name="persontype" id = "persontype" onchange="changeFunc();" >
                                        <option value="0">Diện bình thường</option>
                                        <option value="1">Sinh Viên</option>
                                        <option value="2">Người lao động bị tạm giam</option>
                                        <option value="3">Tính bảo hiểm y tế theo hộ gia đình</option>
                                    </select>
                                </div>    

                                <div class="input-item">
                                    <label for="bhytID">Mã Bảo Hiểm Y Tế</label>
                                    <input type="text" placeholder="Mã Bảo Hiểm Y Tế" name="bhytID" id="bhytID" class="custom-size" >
                                </div>

                                <div class="input-item">
                                    <label for="name">Họ Và Tên</label>
                                    <input type="text" placeholder="Họ Và Tên" name="name" id="name" class="custom-size">
                                </div>

                                <div class="input-item">
                                    <label for="salary">Lương cơ bản</label>
                                    <input type="text" placeholder="  Lương Cơ Bản" name="salary" id="salary" class="custom-size">
                                </div>

                                <h5 style="color: red"><%= request.getAttribute("error2") != null ? request.getAttribute("error2") : " "%></h5>

                            <div id="showIfSelectedEqual3" style="display:none">
                                <div class="input-item">
                                    <label for="bossname">Họ và tên chủ hộ</label>
                                    <input type="text" placeholder="Họ và tên chủ hộ" name="bossname" id="bossname" class="custom-size">
                                </div>

                                <div class="input-item">
                                    <label for="homeid">Số sổ hộ khẩu</label>
                                    <input type="text" placeholder="Số sổ hộ khẩu" name="homeid" id="homeid" class="custom-size">
                                </div>

                                <div class="input-item">
                                    <label for="membercount">Số thành viên trong gia đình</label>
                                    <input type="text" placeholder="" name="membercount" id="membercount" class="custom-size">
                                </div>
                            </div>


                            <div id="showIfSelectdEqual1" style="display: none">
                                <div class="input-item">
                                    <span id="percenttag">Diện dược hỗ trợ</span>
                                    <select name="percent" id = "percent" >
                                        <option value="1">100%</option>
                                        <option value="2">70%</option>
                                        <option value="3">30%</option>
                                        <option value="4">0%</option>
                                    </select>
                                </div>
                            </div>

                            <center>
                                <input type="submit" value="Tính" class="custom-inp button-01">
                            </center>
                        </form>
                    </div>
                </div>

                <div class="grid-item">
                    <div class="grid-item-content">
                        <h3 class="title">Lưu thông tin các thành viên trong gia đình</h3>
                        <p class="subtitle">Nhập cmnd các thành viên trong gia đình</p> <br>
                        <form action="SearchServlet" id = "Searchfamily"  method="POST" class="form-search" >
                            <input type="text" name="content_search" placeholder="  Write a cmnd..." class="search-input">
                            <h5 class="text--red"><%= request.getAttribute("error2") != null ? request.getAttribute("errorequal") : " "%></h5>
                            <input type="hidden" value="<%=user.getcmnd()%>" name="userID">
                            <input type="submit" value="Tìm kiếm" class="custom-inp button-01">
                        </form>

                        <table>
                            <thead>
                                <tr>
                                    <td>CMND</td>
                                    <td>Họ Tên</td>
                                    <td>Ngày Sinh</td>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 0; i < familyMember.size(); i++) {%>
                                <tr>
                                    <td><%=familyMember.get(i).getcmnd()%></td>
                                    <td><%=familyMember.get(i).getUsername()%></td>
                                    <td><%=familyMember.get(i).getDob()%></td>
                                </tr>
                                <%  }   %>
                            </tbody>
                        </table>
                    </div>    
                </div>
            </div>
        </div>
    </body>
    <%
        }
    %>
</html>
