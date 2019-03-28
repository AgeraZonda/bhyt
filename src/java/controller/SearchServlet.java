
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 *
 * @author User
 */
@WebServlet(name = "CommentServlet", urlPatterns = {"/CommentServlet"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset = UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String content = request.getParameter("content_search");
        String pID = request.getParameter("userID");
        if(content.equals("")){

            response.sendRedirect("main.jsp");
        }
        else {
            HttpSession session = request.getSession();
            ArrayList<User> list = new ArrayList<User>();
            list = (ArrayList<User>) session.getAttribute("listmember");
            User user2 = null;
            user2 = (User) session.getAttribute("user");
            UserDao ud = new UserDao();
            User user1 = null;
            if(ud.getUserFromAccount(content) == null)
            {
                session.setAttribute("listmember", list);
                session.setAttribute("user", user2);
                response.sendRedirect("main.jsp");
            }else
            {
            user1 = ud.getUserFromAccount(content);
            if (user1.getUsername() != null || user1.getUsername().equals("") ) {
                list.add(user1);
                session.setAttribute("user", user2);
                session.setAttribute("listmember", list);
                response.sendRedirect("main.jsp");
            } else {
                System.out.println("Error");
            }
            }
        }

    }
}
