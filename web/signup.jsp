<%-- 
    Document   : signup
    Created on : Oct 17, 2018, 3:30:45 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Ký</title>
        <link href="css/common.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/signup.css" rel="stylesheet" type="text/css" media="all" />
    </head>
    <body>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#cmnd").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="img/ajaxloader.gif" />');
                    $.post('CheckcmndServlet', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
            });
        </script>
        <br><br><br><br>
        <div class="signup-area show">
            <div class="signup-infor">
            </div>
            <div class="signup-form">
                <center>
                    <h1 class="signup__title">Đăng Ký!</h1>
                    <span id = "noti" style="display: none; color: red;">Please fill the form fully</span>
                    <h5 style="color: red"><%= request.getAttribute("error") != null ? request.getAttribute("error") : " "%></h5>
                    <!-- <div class="close-button"></div> -->
                    <form method="POST" action="UserServlet">
                        <input type="text" placeholder="  CMND" name="cmnd" id="cmnd" class="custom-size" onclick="checkFull()">
                        <input type="text" placeholder="  Họ và tên" name="uname" id="uname" class="custom-size">
                        <input type="password" placeholder="  Mật khẩu" name="pass" id="pass" class="custom-size">
                        <input type="password" placeholder="  Nhập lại mật khẩu" name="copass" id="pass" class="custom-size">
                        <input type="hidden" value="insert" name="command">
                        <input type="submit" value="Đăng Ký" style="width: 100px;"class="custom-inp button-01">
                    </form>
                     <p style="margin-top: 15px;"><a id="open-modal-signup" href="index.jsp">Đăng Nhập</a></p>
                </center>
            </div>
<!-- 
            <script>
                $('.signup-area .close-button').on('click', function(event) {
                    event.preventDefault();
                    $('.signup-area').removeClass('show');
                });
            </script> -->
        </div>

    </body>
</html>