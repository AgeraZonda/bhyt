/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FamilyDao;
import DAO.UserDao;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.LINE_SEPARATOR;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Family;
import model.User;
import tools.MD5;
import tools.Cacu;

/**
 *
 * @author User
 */
public class CacuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NumberFormatException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bhytID, name, cmnd, homeid = "";
        boolean error = false;
        FamilyDao fd = new FamilyDao();
        int membercount = 2;
        int persontype = 0, salary = 0;
        float resultlist[] = new float[10];
        float result = 0;
        float percent = 0;

        HttpSession session = request.getSession();

        ArrayList<User> list = new ArrayList<User>();

        User user1 = new User();
        user1 = (User) session.getAttribute("user");
        list = (ArrayList<User>) session.getAttribute("listmember");

        user1 = (User) request.getAttribute("user");
        membercount = list.size();

        if (request.getParameter("homeid") != null) {
            homeid = request.getParameter("homeid");
        }
        for (int i = 0; i < membercount; i++) {
            Family fa = new Family();
            fa.setCmnd(user1.getcmnd());
            fa.setHogiadinh_id(homeid);
            fd.insertFamily(fa);
        }

        
        //regex salary
        String salaryString = request.getParameter("salary");
        Pattern regexsalary = Pattern.compile("^[0-9]{6,9}$"); 
        Matcher matcherSalary = regexsalary.matcher(salaryString);
        
       
        
        if (matcherSalary.matches() == false) {
            request.setAttribute("error2", "Lương cơ bản không được để trống, phải là số và lơn hơn 1000000");
            error = true;
        } else {
            salary = Integer.parseInt(salaryString);
        }
        
      
        
//        if (matchMembercount.matches() == false) {
//            request.setAttribute("error3", "Số thành viên trong gia đình trống");
//            error = true;
//        } else {
//            membercount = Integer.parseInt(request.getParameter("membercount"));
//        }
        
        
        // render error              
        if(error) {
            RequestDispatcher rq = request.getRequestDispatcher("main.jsp");
            rq.forward(request, response);
            return;
        }

        if (request.getParameter("bhytID") != null) {
            bhytID = request.getParameter("bhytID");
        }
        if (request.getParameter("name") != null) {
            name = request.getParameter("name");
        }

        if (!request.getParameter("percent").equals("")) {
            percent = Float.valueOf(request.getParameter("percent"));
        } else {
            percent = 0;
        }
        if (!request.getParameter("persontype").equals("")) {
            persontype = Integer.parseInt(request.getParameter("persontype"));
        } else {
            persontype = 0;
        }



        int percentreduce = 0;
        if (percent == 1) {
            percentreduce = 100;
        }
        if (percent == 2) {
            percentreduce = 70;
        }
        if (percent == 3) {
            percentreduce = 30;
        }
        if (percent == 4) {
            percentreduce = 0;
        }

        Cacu ca = new Cacu();

        if (persontype == 0) {
            result = ca.caculate(salary, percentreduce);
        }
        if (persontype == 1) {
            percentreduce = 70;
            result = ca.caculate(1390000, percentreduce);
        }
        if (persontype == 2) {
            result = ca.caculate((float) (salary * 0.5), percentreduce);
        }
        if (persontype == 3) {
            resultlist = ca.caculateForFamily(salary, membercount);
        }

        String someMessage = "Error !";
        PrintWriter out = response.getWriter();
        out = response.getWriter();
        response.setContentType("text/html");
        out.println("<a href=\"index.jsp?userID=<%=user.getUserID()%>\" style=\"text-transform: uppercase;\"><b>Home</b></a>");

        response.setContentType("text/html");
        if (persontype == 3) {
            for (int i = 0; i < membercount; i++) {

                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");

                out.println("<div><p>Phi bhyt cua thanh vien thu " + (i + 1) + " la: " + resultlist[i] + " VND</p></div>");
            }

        } else {

            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
            out.println("<a href=\"index.jsp?userID=<%=user.getUserID()%>\" style=\"text-transform: uppercase;\"><b>Home</b></a>");
            out.println("<div><p>Phi bhyt cua cua ban la: " + result + " VND</p></div>");
        }

    }

}
