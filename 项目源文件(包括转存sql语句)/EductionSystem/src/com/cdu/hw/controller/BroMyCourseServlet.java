package com.cdu.hw.controller;

import com.cdu.hw.dao.CourseDao;
import com.cdu.hw.dao.daoImpl.CourseDaoImpl;
import com.cdu.hw.model.CourseInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/broMyCourse")
public class BroMyCourseServlet extends HttpServlet {
    CourseDao dao= new CourseDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String spid=(String) req.getSession().getAttribute("username1");
        System.out.println(spid);
        List<CourseInfo> jibens = dao.searchcouinfo(spid);
        if(jibens==null){
            System.out.println("没有查询到数据。");
        }else {
            System.out.println("查询到数据。");
        }
        req.setAttribute("jibens",jibens);
        System.out.println("看看是否运行");
        req.getRequestDispatcher("/view/liulancou.jsp").forward(req, resp);
    }
}
