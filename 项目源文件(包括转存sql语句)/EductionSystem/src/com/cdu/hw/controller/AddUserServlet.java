package com.cdu.hw.controller;

import com.cdu.hw.dao.CourseDao;
import com.cdu.hw.dao.UserDao;
import com.cdu.hw.dao.daoImpl.CourseDaoImpl;
import com.cdu.hw.dao.daoImpl.UserDaoImpl;
import com.cdu.hw.model.Course;
import com.cdu.hw.model.Student;
import com.cdu.hw.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    UserDao dao = new UserDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("addtea".equals(method)) {
            addtea(req,resp);
        }else if("addstu".equals(method)) {
            addstu(req,resp);
        }else if("addcou".equals(method)) {
            addcou(req,resp);
        }
    }
    private void addtea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tpid = req.getParameter("tpid");
        String teaname = req.getParameter("teaname");
        String sex = req.getParameter("sex");
        String txueyuan = req.getParameter("txueyuan");
        String zhicheng = req.getParameter("zhicheng");
        int pid=1;
        String password = "123456";
        Teacher teacher=new Teacher(tpid,teaname,sex,txueyuan,zhicheng);
        if(dao.addtea(teacher)&&dao.adduser(tpid,password,pid)) {
            req.setAttribute("teacher",teacher);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("/view/addtea.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","老师姓名重复，请重新输入" );
            req.getRequestDispatcher("/view/addtea.jsp").forward(req, resp);
        }
    }

    private void addstu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String spid = req.getParameter("spid");
        String stuname = req.getParameter("stuname");
        String sex = req.getParameter("sex");
        String banji = req.getParameter("banji");
        String ye = req.getParameter("ye");
        Student student =new Student(spid,stuname,sex,banji,ye);
        int pid=2;
        String password="123456";
        if(dao.addstu(student)&&dao.adduser(spid, password, pid)) {
            req.setAttribute("stu", student);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("/view/addstu.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","学生姓名重复，请重新输入" );
            req.getRequestDispatcher("/view/addstu.jsp").forward(req, resp);
        }
    }

    private void addcou(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String jiaoshi=(String) req.getSession().getAttribute("teaname");
        String cpid = req.getParameter("cpid");
        String cname = req.getParameter("cname");
        int num = Integer.parseInt(req.getParameter("num"));
        int snum=0;
        System.out.println(jiaoshi);
        CourseDao courseDao=new CourseDaoImpl();
        Course course =new Course(cpid,cname,num,snum,jiaoshi);
        if(courseDao.addcou(course)) {
            req.setAttribute("cou", course);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("/view/addcourse.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","课程信息重复，请重新输入" );
            req.getRequestDispatcher("/view/addcourse.jsp").forward(req, resp);
        }
    }
}
