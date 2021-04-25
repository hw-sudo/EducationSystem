package com.cdu.hw.dao.daoImpl;

import com.cdu.hw.dao.UserDao;
import com.cdu.hw.model.Student;
import com.cdu.hw.model.Teacher;
import com.cdu.hw.util.DBUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public int searchPid(String username,String password)
    {
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        int pid=0;
        try {
            String sql="select pid from user where username= '"+username+"' and password='"+password+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                pid = rs.getInt("pid");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(state, conn);
        }
        return pid;
    }

    @Override
    public boolean addtea(Teacher teacher)
    {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into teacher(tpid,teaname,sex,txueyuan,zhicheng) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getTpid());
            pstmt.setString(2, teacher.getTeaname());
            pstmt.setString(3, teacher.getSex());
            pstmt.setString(4, teacher.getTxueyuan());
            pstmt.setString(5, teacher.getZhicheng());
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
    public boolean adduser(String tpid,String password,int pid)
    {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into user(username,password,pid) value(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tpid);
            pstmt.setString(2, password);
            pstmt.setInt(3, pid);
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
    public boolean addstu(Student student)
    {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into stu(spid,stuname,sex,banji,ye) value(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getSpid());
            pstmt.setString(2, student.getStuname());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getBanji());
            pstmt.setString(5, student.getYe());
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
    public boolean delstu(String spid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a = 0;
        String sql = "DELETE FROM stu WHERE spid=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, spid);
            a = pstmt.executeUpdate();
        } catch (SQLException e) {
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
    public boolean deluser(String username) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a = 0;
        String sql = "DELETE FROM user WHERE username=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            a = pstmt.executeUpdate();
        } catch (SQLException e) {
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
    public boolean delstuAndcou(String spid, String cpid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a = 0;
        String sql = "DELETE FROM jiben where spid= '"+spid+"' and cpid='"+cpid+"'";

        try {
            pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1, spid);
            //pstmt.setString(2, cpid);
            a = pstmt.executeUpdate();
        } catch (SQLException e) {
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
    public  String searchteaname(String tpid)
    {
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        String tea_name=null;
        try {
            String sql="select teaname from teacher where tpid= '"+tpid+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                tea_name = rs.getString("tea_name");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(state, conn);
        }
        return tea_name;
    }

    @Override
    public boolean updatetea(Teacher teacher) {
        String sql = "update teacher set teaname='" + teacher.getTeaname() + "', sex='" + teacher.getSex()
                + "', txueyuan='" +teacher.getTxueyuan() + "',zhicheng='" +teacher.getZhicheng() + "'where tpid='" + teacher.getTpid() + "'";
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
    public boolean updatestu(Student student) {
        String sql = "update stu set stuname='" + student.getStuname() + "', sex='" + student.getSex()
                + "', banji='" + student.getBanji() + "',ye='" + student.getYe() + "'where spid='" + student.getSpid() + "'";
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
    public String searchtpid(String jiaoshi) {
        String sql = "select tpid from teacher where teaname= '"+jiaoshi+"'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        String tpid=null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                tpid=rs.getString("tpid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return tpid;
    }

    @Override
    public Student searchstu(String spid) {
        String sql = "select * from stu where spid= '"+spid+"'";
        Student student = null;
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //int id = rs.getInt("id");
                String spid1 = rs.getString("spid");
                String stuname = rs.getString("stuname");
                String sex = rs.getString("sex");
                String banji = rs.getString("banji");
                String ye = rs.getString("ye");
                student = new Student(spid1, stuname, sex ,banji,ye);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return student;
    }


}
