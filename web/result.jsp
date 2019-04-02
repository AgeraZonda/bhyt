<%-- 
    Document   : result
    Created on : Apr 2, 2019, 6:03:53 PM
    Author     : nguye
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script src="js/jquery-3.2.1.min.js"></script>
        <title>JSP Page</title>
    </head>

    <body>
        <%

            User user = new User();

            if (session.getAttribute("user") == null) {

        %>
    <center><h1 style="padding-top: 200px" class="title">You need to login</h1></center>


    <%                } else {
        ArrayList<User> familyMember = new ArrayList<User>();
        float resultlist[] = new float[10];
        if (session.getAttribute("listmember") != null) {

            familyMember = (ArrayList<User>) session.getAttribute("listmember");
        }
        if (session.getAttribute("resultlist") != null) {

            resultlist = (float[]) session.getAttribute("resultlist");
        }
        int type = (int) session.getAttribute("type");
        System.out.println(type);
        if (type == 1) {

    %>
    <jsp:include page="header.jsp"></jsp:include>
        <center>
            <h1>Kết quả tính phí theo hộ gia đình</h1>
            <br>
            <table>
                <thead>
                    <tr>
                        <td>CMND</td>
                        <td>Họ Tên</td>
                        <td>Ngày Sinh</td>
                        <td>Phí BHYT</td>
                    </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < familyMember.size(); i++) {%>
                <tr>
                    <td><%=familyMember.get(i).getcmnd()%></td>
                    <td><%=familyMember.get(i).getUsername()%></td>
                    <td><%=familyMember.get(i).getDob()%></td>
                    <td><%=resultlist[i]%></td>
                </tr>
                <%  }%>
            </tbody>
        </table>
    </center>

    <% } else {
        float result = 0;

        if (session.getAttribute("result") != null) {
            result = (float) session.getAttribute("result");
        }

    %>
    <jsp:include page="header.jsp"></jsp:include>
        <center>
            <h1>Kết quả tính phí</h1>
            <br>
            <p>Phi bhyt cua cua ban la: " <%=result%> " VND</p>

    </center>
    <%}
        }
    %>
    <body>
</html>
