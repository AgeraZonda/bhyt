/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AccountDao;
import DAO.UserDao;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Account;
import model.User;
import tools.MD5;

/**
 *
 * @author User
 */
public class UserServlet extends HttpServlet {

    UserDao userDao = new UserDao();
    AccountDao accountDao = new AccountDao();

    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String url = "index.jsp";
        String name = "";
        User user = new User();
        Account account = new Account();
        HttpSession session = request.getSession();
        switch (command) {
            case "insert":
//                    user.setHoten(request.getParameter("hoten"));
//                    user.setNgaysinh(Date.valueOf(request.getParameter("ngaysinh")));
//                    user.setSdt(request.getParameter("sdt"));
                String cmnd = request.getParameter("cmnd");
                Pattern regex = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcher = regex.matcher(cmnd);
                String uname = request.getParameter("uname");
                String password = request.getParameter("pass");
                String cfpassword = request.getParameter("copass");
                User getUser = new User();
                if (cmnd.equals("") || cmnd == null) {
                    request.setAttribute("error", "cmnd không được để null");
                    request.setAttribute("uname", uname);

                    RequestDispatcher rq = request.getRequestDispatcher(url);
                    rq.forward(request, response);
                }

                if (uname.equals("") || uname == null) {
                    request.setAttribute("error", "UserName không được để null");
                    request.setAttribute("cmnd", cmnd);
                    RequestDispatcher rq = request.getRequestDispatcher(url);
                    rq.forward(request, response);
                }
                Pattern regexUname = Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]");
                Matcher matcherUname = regexUname.matcher(uname);
                if (password.equals("") || password == null) {
                    request.setAttribute("error", "Pass không được để null");
                    request.setAttribute("cmnd", cmnd);
                    request.setAttribute("uname", uname);
                    RequestDispatcher rq = request.getRequestDispatcher(url);
                    rq.forward(request, response);
                }
//                Pattern regexPass = Pattern.compile("[$&+,:;=?@#|'<>.-^*()%!]");
//                Matcher matcherPass = regexPass.matcher(password);
//                if (matcherPass.find()) {
//                    request.setAttribute("error", "Password không được chứa ký tự đặc biệt ");
//                    request.setAttribute("uname", uname);
//
//                    RequestDispatcher rq = request.getRequestDispatcher(url);
//                    rq.forward(request, response);
//                }
                if (!cfpassword.equals(password)) {
                    request.setAttribute("error", "Confirm password is wrong");
                    request.setAttribute("cmnd", cmnd);
                    request.setAttribute("uname", uname);
                    RequestDispatcher rq = request.getRequestDispatcher(url);
                    rq.forward(request, response);
                }

                if (!cmnd.equals("") && cmnd != null && !password.equals("") && password != null && !uname.equals("") && uname != null && cfpassword.equals(password)) {
                    String pass = MD5.encryption(request.getParameter("pass"));
                    boolean checkcmnd = accountDao.checkcmnd(cmnd);
                    if (checkcmnd == true) {
                        request.setAttribute("error", "cmnd đã tồn tại");
                        request.setAttribute("cmnd", cmnd);
                        request.setAttribute("uname", uname);
                        RequestDispatcher rq = request.getRequestDispatcher(url);
                        rq.forward(request, response);
                    } else {
                        user.setcmnd(cmnd);
                        user.setUsername(uname);
                        user.setAdmin(2);
                        account.setCmnd(cmnd);
                        account.setPassword(pass);

                        userDao.inseartUser(user);
                        accountDao.inseartUser(account);
                        session.setAttribute("user", user);
                        RequestDispatcher rq = request.getRequestDispatcher(url);
                        rq.forward(request, response);
                        break;
                    }
                }
            case "login":
                User user3 = new User();
                user3 = accountDao.login(request.getParameter("login-cmnd"), MD5.encryption(request.getParameter("login-pass")));


                if (user != null) {

                    session.setAttribute("user", user3);
                    ArrayList<User> list = new ArrayList<User>();

                    session.setAttribute("listmember", list);

                    response.sendRedirect(url);
                } else {
                    request.setAttribute("error", "Wrong cmnd or password");
                    response.sendRedirect(url);
                }
                break;
            case "logout":
                session.setAttribute("user", null);
                session.setAttribute("listmember", null);
                response.sendRedirect("index.jsp");
//                case "update":
//                    user.setUserID(userDao.sizeUser());
//                    user.setHoten(request.getParameter("hoten"));
//                    user.setNgaysinh(Date.valueOf(request.getParameter("ngaysinh")));
//                    user.setcmnd(request.getParameter("cmnd"));
//                    user.setSdt(request.getParameter("sdt"));
//                    userDao.updateUser(user); 
//                    session.setAttribute("user",user);
//                    url = "/index.jsp";
                break;

            case "update": {
                String newfullname = request.getParameter("name");
                String newngaysinh = request.getParameter("dob");
                String newdantoc = request.getParameter("dantoc");
                String newtenngdamho = request.getParameter("ngdamho");
                String newgioitinh = request.getParameter("gioitinh");
                String newquequan = request.getParameter("quequan");
                String newbhxh = request.getParameter("bhxh");
                String newhogiadinhid = request.getParameter("hogiadinh");
//                String id = request.getParameter("userID");
//                long num = Long.parseLong(id);
                User user1 = new User();
                boolean error = false;
                Account account1 = new Account();
                user1 = (User) session.getAttribute("user");
                System.out.println(user1.getUserID());
//                user1.setUserID(num);
                user1.setBhxh_id(newbhxh);
                user1.setDantoc(newdantoc);
                user1.setDob(newngaysinh);
                user1.setGioitinh(newgioitinh);
                user1.setHogiadinh_id(newhogiadinhid);
                user1.setHotennguoidamho(newtenngdamho);
                user1.setQuequan(newquequan);
                user1.setUsername(newfullname);
                Pattern regexdob = Pattern.compile("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                        + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                        + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                        + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
                Matcher matcherdob = regexdob.matcher(newngaysinh);

                //Regex fullname
                Pattern regexNewfullname = Pattern.compile("^[a-zA-Z\\s]{1,50}$");
                Matcher matcherNewfullname = regexNewfullname.matcher(newfullname);

                //Regex dantoc
                Pattern regexNewdantoc = Pattern.compile("^[a-zA-Z\\s]{1,10}$");
                Matcher matcherNewdantoc = regexNewfullname.matcher(newdantoc);

                //Regex tennguoigiamho
                Pattern regexNewtenngdamho = Pattern.compile("^[a-zA-Z\\s]{1,50}$");
                Matcher matchNewtenngdamho = regexNewtenngdamho.matcher(newtenngdamho);

                //Regex gioitinh: Nam or Nu
                Pattern regexNewgioitinh = Pattern.compile("^[a-zA-Z]{2,3}$");
                Matcher matchNewgioitinh = regexNewgioitinh.matcher(newgioitinh);

                //regex quequan
                Pattern regexNewquequan = Pattern.compile("^[a-zA-Z\\s]{1,100}$");
                Matcher matchNewquequan = regexNewquequan.matcher(newquequan);

                //regex ma bhxh: CH1234567894561 (mã BHXH gồm 2 phần: phần 1: CH,DN,...(gồm 2 chữ cái), phần 2: 51224....(13 chữ số))
                Pattern regexNewbhxh = Pattern.compile("^[CH|DN|NN|HT|CT|XB|TN|QN|CA|CY|MS|CC|HD|TE|DT|CN|HS|SV]{2}[1-5]{1}[0-9]{12}$");
                Matcher matchNewbhxh = regexNewbhxh.matcher(newbhxh);

                //regex ma hogiadinh
                Pattern regexNewmahogiadinhid = Pattern.compile("^[0-9]{10}$");
                Matcher matchNewmahogiadinhid = regexNewmahogiadinhid.matcher(newhogiadinhid);

                if (matcherNewfullname.matches() == false) {
                    request.setAttribute("error2", "Họ tên không được để trống hoặc có ký tự đặc biệt");
                    error = true;
                }
                if (matcherdob.matches() == false) {
                    request.setAttribute("error3", "sai định dạng ngày tháng");
                    error = true;
                }

                if (matcherNewdantoc.matches() == false) {
                    request.setAttribute("error4", "Khong được để trống dân tộc hoặc thừa ký tự đặc biệt");
                    error = true;
                }
                if (matchNewtenngdamho.matches() == false) {
                    request.setAttribute("error5", "Tên người dám hộ không được để trống hoặc có ký tự đặc biệt");
                    error = true;
                }
                if (matchNewgioitinh.matches() == false) {
                    request.setAttribute("error6", "Giới tính chỉ có thể là Nam hoặc Nu");
                    error = true;
                }
                if (matchNewquequan.matches() == false) {
                    request.setAttribute("error7", "Quên quán không được để trống hoặc có ký đặc biệt");
                    error = true;
                }
                if (matchNewbhxh.matches() == false && !newbhxh.equals("")) {
                    request.setAttribute("error8", "Không đúng định dạng mã BHXH");
                    error = true;
                }
                if (matchNewmahogiadinhid.matches() == false && !newhogiadinhid.equals("")) {
                    request.setAttribute("error9", "Không đúng định dạng mã hộ gia đình");
                    error = true;
                }

                if (error) {
                    RequestDispatcher rq = request.getRequestDispatcher("ttcn.jsp");
                    rq.forward(request, response);
                    return;
                }

                long id = user1.getUserID();

//                userDao.updateUser(user1);
                UserDao userDao1 = new UserDao();
                try {
                    if (userDao1.updateUser(user1)) {
                        response.sendRedirect("index.jsp");
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }

        }
    }

}
