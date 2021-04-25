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

@WebServlet("/broinfo")
public class BroInfo extends HttpServlet {

    CourseDao dao=new CourseDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spid=req.getParameter("spid");
        String cpid=req.getParameter("cpid");
        List<CourseInfo> jibens = dao.searchstuinfo(spid,cpid);
        req.setAttribute("jibens",jibens);
        req.getRequestDispatcher("/view/mod_score.jsp").forward(req, resp);
    }
}
