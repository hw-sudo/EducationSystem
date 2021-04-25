package com.cdu.hw.controller;

import com.cdu.hw.dao.CourseDao;
import com.cdu.hw.dao.UserDao;
import com.cdu.hw.dao.daoImpl.CourseDaoImpl;
import com.cdu.hw.dao.daoImpl.UserDaoImpl;
import com.cdu.hw.model.Course;
import com.cdu.hw.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/choose")
public class ChooseCourseServlet extends HttpServlet {

    CourseDao dao=new CourseDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("liulankecheng".equals(method)) {
            liulankecheng(req,resp);
        }else if("chakan".equals(method)) {
            chakan(req,resp);
        }else if("xuanke".equals(method)) {
            xuanke(req,resp);
        }else if("liulankecheng1".equals(method)) {
            liulankecheng1(req,resp);
        }
    }

    private void liulankecheng(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Course> course = dao.liulankecheng();
        req.setAttribute("course", course);
        req.getRequestDispatcher("/view/liulankecheng.jsp").forward(req, resp);

    }

    private void chakan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Course course =dao.searchByid(id);
        req.getSession().setAttribute("id", id);
        req.setAttribute("course", course);
        req.getRequestDispatcher("/view/chakankecheng.jsp").forward(req, resp);
    }

    private void xuanke(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserDao userDao=new UserDaoImpl();
        String spid =(String) req.getSession().getAttribute("username1");
        String cpid = req.getParameter("cpid");
        int snum = Integer.parseInt(req.getParameter("snum"))+1;
        String jiaoshi = req.getParameter("jiaoshi");
        int id =(int) req.getSession().getAttribute("id");
        String tpid=userDao.searchtpid(jiaoshi);
        Student student = userDao.searchstu(spid);
        System.out.println(id);
        if(dao.updatecou(id,snum)&&dao.addjiben(cpid,tpid,spid, student)) {
            req.setAttribute("message","选课成功" );
            req.getRequestDispatcher("/view/success.jsp").forward(req, resp);
        } else {
            req.setAttribute("message","选课失败" );
            req.getRequestDispatcher("/view/success.jsp").forward(req, resp);
        }
    }

    private void liulankecheng1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Course> course = dao.liulankecheng1();
        req.setAttribute("course", course);
        req.getRequestDispatcher("/view/liulankecheng1.jsp").forward(req, resp);

    }
}
