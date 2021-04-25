package com.cdu.hw.controller;

import com.cdu.hw.dao.CourseDao;
import com.cdu.hw.dao.UserDao;
import com.cdu.hw.dao.daoImpl.CourseDaoImpl;
import com.cdu.hw.dao.daoImpl.UserDaoImpl;
import com.cdu.hw.model.Student;
import com.cdu.hw.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpadteInfoServlet extends HttpServlet {

    UserDao dao=new UserDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("updatetea".equals(method)) {
            updatetea(req,resp);
        }else if("updatestu".equals(method)) {
            updatestu(req,resp);
        }else if("mod_score".equals(method)) {
            mod_score(req,resp);
        }    }

    private void updatetea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tpid=(String) req.getSession().getAttribute("username");
        String teaname = req.getParameter("teaname");
        String sex = req.getParameter("sex");
        String txueyuan = req.getParameter("txueyuan");
        String zhicheng = req.getParameter("zhicheng");
        Teacher teacher=new Teacher(tpid,teaname,sex,txueyuan,zhicheng);
        if(dao.updatetea(teacher)) {
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("/view/updatet.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("/view/updatet.jsp").forward(req, resp);
        }
    }

    private void updatestu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String spid =(String) req.getSession().getAttribute("username1");
        String stuname = req.getParameter("stuname");
        String sex = req.getParameter("sex");
        String banji = req.getParameter("banji");
        String ye = req.getParameter("ye");
        Student student =new Student(spid,stuname,sex,banji,ye);
        if(dao.updatestu(student)) {
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("/view/updates.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("/view/updates.jsp").forward(req, resp);
        }
    }

    CourseDao courseDao=new CourseDaoImpl();

    private void mod_score(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String spid=req.getParameter("spid");
        String cpid=req.getParameter("cpid");
        String score=req.getParameter("score");
        if(courseDao.mod_score(spid,cpid,score)){
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("/view/liulanstu.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("/view/liulanstu.jsp").forward(req, resp);
        }


    }
}
