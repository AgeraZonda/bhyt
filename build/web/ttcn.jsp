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
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>
       
       <div class="header-page--02">
        
       </div>
        <%
            User user = new User();
         if (session.getAttribute("user") == null) {

        %>
    <center><h1 style="padding-top: 200px" class="title">You need to login</h1></center>
        

        <%                } else {

            user = (User) session.getAttribute("user");

            
        %>
        <jsp:include page="header.jsp"></jsp:include>
    <div class="information-content">
        <h1 class="information__title">Information</h1> <br>
        <h2 class="information__sebtitle"><%= user.getUsername()%></h2>
        <br>
        <form method="POST" action="UserServlet" class="form-01">
<!--                        <input type="hidden" value="<%= user.getUserID()%>" name="userID" id="userID">-->

            <div class="input-wrapper">
                <div class="input-item">
                    <p class="label">CMND<span class="text--red">*</span></p>
                    <input type="text" value="<%=user.getcmnd()%>" name="cmnd" id="cmnd" class="custom-size" disabled>
                </div>    
                
                <div class="input-item">
                    <p class="label">Full Name<span class="text--red">*</span></p>
                    <span id="user-result"></span>
                    <input type="text" value="<%=user.getUsername()%>" name="name" id="name" class="custom-size" >
                    <h5 class="text--red"><%= request.getAttribute("error2") != null ? request.getAttribute("error2") : " "%></h5>
                </div>

                
                <div class="input-item">
                    <p class="label">Ngày Sinh (yyyy-mm-dd)<span class="text--red">*</span></p>
                    <input type="text" value="<%=user.getDob()%>" name="dob" id="dob" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error3") != null ? request.getAttribute("error3") : " "%></h5>
                </div>

                <div class="input-item">
                    <p class="label">Dân Tộc<span class="text--red">*</span></p>
                    <input type="text" value="<%=user.getDantoc()%>" name="dantoc" id="dantoc" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error4") != null ? request.getAttribute("error4") : " "%></h5>
                </div>

                <div class="input-item">
                    <p class="label">Mã Số BHXH(đã cấp)</p>
                    <input type="text" value="<%=user.getBhxh_id()%>" name="bhxh" id="bhxh" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error8") != null ? request.getAttribute("error8") : " "%></h5>
                </div>


                <div class="input-item">
                    <p class="label">Giới Tính<span class="text--red">*</span></p>
                    <input type="text" value="<%=user.getGioitinh()%>" name="gioitinh" id="gioitinh" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error6") != null ? request.getAttribute("error6") : " "%></h5>
                </div>
                
                <div class="input-item">
                    <p class="label">Quê Quán<span class="text--red">*</span></p>
                    <input type="text" value="<%=user.getQuequan()%>" name="quequan" id="quequan" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error7") != null ? request.getAttribute("error7") : " "%></h5>
                </div>

                <div class="input-item">
                    <p class="label">Mã Số Hộ Gia Đình(đã cấp)</p>
                    <input type="text" value="<%=user.getHogiadinh_id()%>" name="hogiadinh" id="hogiadinh" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error9") != null ? request.getAttribute("error9") : " "%></h5>
                </div>
                
                <div class="input-item">
                    <p class="label">Họ tên người dám hộ(đối với trẻ em dưới 6 tuổi)<span class="text--red">*</span></p>
                    <input type="text" value="<%=user.getHotennguoidamho()%>" name="ngdamho" id="ngdamho" class="custom-size">
                    <h5 class="text--red"><%= request.getAttribute("error5") != null ? request.getAttribute("error5") : " "%></h5>
                </div>
            </div>
            
            

            
            <!--                        <br><br>-->
            <!--                        <input type="password" placeholder="  OldPassword" name="opass" id="pass" class="custom-size">
                                    <br><br>
                                    <input type="password" placeholder="  Password" name="pass" id="pass" class="custom-size">
                                    <br><br>
                                    <input type="password" placeholder="Confirm Password" name="copass" id="pass" class="custom-size">
                                    <br><br>-->
            <input type="hidden" value="update" name="command">
            <input type="submit" class="button-01" value="Update" class="custom-inp">
        </form>
    </div>
</body>
    <%
        }
    %>
</html>
