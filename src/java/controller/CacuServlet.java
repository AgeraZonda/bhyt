/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDao;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
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

        String url = "details.jsp";
        User user = new User();
        HttpSession session = request.getSession();
        String bhytID = request.getParameter("bhytID");
        String name = request.getParameter("name");
        String cmnd = request.getParameter("cmnd");
        String dob = request.getParameter("dob");
        String type = request.getParameter("percent");
        System.out.println(type);
        int salary = Integer.parseInt(request.getParameter("salary")) ;
        RequestDispatcher rq = request.getRequestDispatcher(url);
        rq.forward(request, response);
        

    }

}
