package com.cdu.hw.controller;

import com.cdu.hw.dao.UserDao;
import com.cdu.hw.dao.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserDao dao=new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        String inputCode = req.getParameter("inputCode");
        int pid=dao.searchPid(username,password);
        if(pid==1||pid==2||pid==3) {
            HttpSession session = req.getSession();
            String validCode = (String) session.getAttribute("validCode");
            req.getSession().setAttribute("validCode", validCode);

            if (validCode == null || validCode.equals("") || !validCode.equals(inputCode)) {
                req.setAttribute("message", "验证码错误");
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            } else {

                if (pid == 1) {
                    System.out.println(pid);
                    String tea_name = dao.searchteaname(username);
                    System.out.println(tea_name);
                    req.getSession().setAttribute("username", username);
                    req.getSession().setAttribute("tea_name", tea_name);
                    req.getRequestDispatcher("/view/1.jsp").forward(req, resp);
                } else if (pid == 2) {
                    System.out.println(pid);
                    req.getSession().setAttribute("username1", username);
                    req.getRequestDispatcher("/view/2.jsp").forward(req, resp);
                } else {
                    System.out.println(pid);
                    req.getRequestDispatcher("/view/3.jsp").forward(req, resp);
                }
            }
        }
        else{
            req.setAttribute("message","账号或密码错误" );
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }
    }
}
