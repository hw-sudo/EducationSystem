package com.cdu.hw.dao.daoImpl;

import com.cdu.hw.dao.CourseDao;
import com.cdu.hw.model.Course;
import com.cdu.hw.model.CourseInfo;
import com.cdu.hw.model.Student;
import com.cdu.hw.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public boolean addcou(Course course)
    {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into cou(cpid,cname,num,snum,jiaoshi) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getCpid());
            pstmt.setString(2, course.getCname());
            pstmt.setInt(3, course.getNum());
            pstmt.setInt(4, course.getSnum());
            pstmt.setString(5, course.getJiaoshi());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }

    @Override
    public List<Course> liulankecheng() {
        String sql = "select * from cou";
        List<Course> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Course bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                bean = new Course(id,cpid, cname, num ,snum,jiaoshi);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return list;
    }

    @Override
    public Course searchByid(int id) {
        String sql = "select * from cou where id= '"+id+"'";
        Course course = null;
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                course = new Course(cpid, cname, num ,snum,jiaoshi);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return course;
    }

    @Override
    public boolean updatecou(int id,int snum) {
        String sql="update cou set snum='" + snum + "'where id='" + id +"'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println("看看是不是执行了");
            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }

        System.out.println(f);
        return f;

    }

    @Override
    public boolean addjiben(String cpid, String tpid, String spid, Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into jiben(cpid,tpid,spid,stuname,sex,banji,ye) value(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cpid);
            pstmt.setString(2, tpid);
            pstmt.setString(3, spid);
            pstmt.setString(4, student.getStuname());
            pstmt.setString(5, student.getSex());
            pstmt.setString(6, student.getBanji());
            pstmt.setString(7, student.getYe());
            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }

    @Override
    public List<Course> liulankecheng1() {
        String sql = "select * from cou";
        List<Course> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Course bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String cname = rs.getString("cname");
                int num = rs.getInt("num");
                int snum = rs.getInt("snum");
                String jiaoshi = rs.getString("jiaoshi");
                if(snum<num) {
                    bean = new Course(id,cpid, cname, num ,snum,jiaoshi);
                    list.add(bean);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return list;
    }

    @Override
    public List<CourseInfo> searchstuinfo(String tpid) {
        String sql = "select * from jiben where tpid= '"+tpid+"'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        List<CourseInfo> list = new ArrayList<>();

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            CourseInfo Info = null;
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String tpid1 = rs.getString("tpid");
                String spid = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                String score = rs.getString("score");
                Info = new CourseInfo(cpid,tpid1,spid,stuname,sex ,banji,ye,score);
                list.add(Info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        return list;
    }

    @Override
    public List<CourseInfo> searchstuinfo(String spid,String cpid) {
        String sql = "select * from jiben where spid= '"+spid+"' and cpid='"+cpid+"'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        List<CourseInfo> list = new ArrayList<>();

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            CourseInfo Info = null;
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid1 = rs.getString("cpid");
                String tpid = rs.getString("tpid");
                String spid1 = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                String score = rs.getString("score");
                Info = new CourseInfo(cpid1,tpid,spid1,stuname,sex ,banji,ye,score);
                list.add(Info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        return list;
    }

    @Override
    public List<CourseInfo> searchcouinfo(String spid) {
        String sql = "select * from jiben where spid= '"+spid+"'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        List<CourseInfo> list = new ArrayList<>();

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            CourseInfo Info = null;
            while (rs.next()) {
                //int id = rs.getInt("id");
                String cpid = rs.getString("cpid");
                String tpid = rs.getString("tpid");
                String spid1 = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                String score = rs.getString("score");
                Info = new CourseInfo(cpid,tpid,spid1,stuname,sex ,banji,ye,score);
                list.add(Info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }
        return list;
    }

    @Override
    public boolean mod_score(String spid, String cpid,String score) {
        String sql="update jiben set score='" + score + "'where spid='" + spid +"' and  cpid='" + cpid + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();
            System.out.println("看看是不是执行了");
            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }

        System.out.println(f);
        return f;
    }
}
