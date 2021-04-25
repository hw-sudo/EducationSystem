package com.cdu.hw.controller;

import com.cdu.hw.dao.UserDao;
import com.cdu.hw.dao.daoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {

    UserDao userDao=new UserDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spid=req.getParameter("spid");
        String cpid=req.getParameter("cpid");
        if(userDao.delstuAndcou(spid,cpid)){
            req.setAttribute("message","删除成功" );
            req.getRequestDispatcher("/view/liulanstu.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","删除失败" );
            req.getRequestDispatcher("/view/liulanstu.jsp").forward(req, resp);
        }
    }
}
