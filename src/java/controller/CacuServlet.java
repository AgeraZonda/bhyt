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
            throws ServletException, IOException ,NumberFormatException{

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bhytID,name,cmnd;
        int persontype = 0,membercount = 0,salary=0;
        float resultlist[]= new float[10];
        float result = 0;
        float percent = 0;

        if(request.getParameter("bhytID")!=null)
        {
            bhytID = request.getParameter("bhytID");
        }
        if(request.getParameter("name")!=null)
        {
            name = request.getParameter("name");
        }
        if(request.getParameter("cmnd")!=null)
        {
            cmnd = request.getParameter("cmnd");
        }
        if(!request.getParameter("percent").equals(""))
        {
            percent = Float.valueOf(request.getParameter("percent"));
        }else percent = 0;
        if(!request.getParameter("persontype").equals(""))
        {
            persontype = Integer.parseInt(request.getParameter("persontype"));
        }else persontype = 0;
        if(!request.getParameter("membercount").equals(""))
        {
            membercount = Integer.parseInt(request.getParameter("membercount"));
        }else membercount = 0;
        
        if(!request.getParameter("salary").equals(""))
        {
            salary = Integer.parseInt(request.getParameter("salary")) ;
        }else salary = 0;

        
        
        int percentreduce = 0;
        if(percent == 1) percentreduce = 100;
        if(percent == 2) percentreduce = 70;
        if(percent == 3) percentreduce = 30;
        if(percent == 4) percentreduce = 0;
        
        Cacu ca = new Cacu();
        
        if(persontype == 0)  
        {
            result = ca.caculate(salary,percentreduce);
        }
        if(persontype == 1)  
        {
            percentreduce = 70;
            result = ca.caculate(1390000,percentreduce);
        }
        if(persontype == 2)  
        {
            result = ca.caculate((float) (salary*0.5),percentreduce);
        }
        if(persontype == 3)
        {
            resultlist = ca.caculateForFamily(salary,membercount );
        }
       
        String someMessage = "Error !";
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if(persontype == 3)
        {
            for(int i =0;i<membercount;i++)
            {
                out.println("phi bhyt cua thanh vien thu :"+i+" la: "+ resultlist[i] +"VND");
            }
                        
        }
        else
        {
            out.println("phi bhyt cua ban la :"+result+ "VND");
        }
        
        

    }

}
