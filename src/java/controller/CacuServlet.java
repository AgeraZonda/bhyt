/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDao;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bhytID = request.getParameter("bhytID");
        String name = request.getParameter("name");
        String cmnd = request.getParameter("cmnd");
        int percent = Integer.parseInt(request.getParameter("percent"));
        int percentreduce = 0;
        if(percent == 1) percentreduce = 100;
        if(percent == 2) percentreduce = 70;
        if(percent == 3) percentreduce = 30;
        if(percent == 4) percentreduce = 0;
        int salary = Integer.parseInt(request.getParameter("salary")) ;
        Cacu ca = new Cacu();
        float result = ca.caculate(salary,percentreduce);
        String someMessage = "Error !";
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("phi bhyt cua ban la :"+result+ "VND");
        

    }

}
