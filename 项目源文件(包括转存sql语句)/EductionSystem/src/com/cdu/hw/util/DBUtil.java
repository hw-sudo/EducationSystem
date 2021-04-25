package com.cdu.hw.util;

import java.sql.*;

/**
 * 数据库连接工具
 *
 */
public class DBUtil {

    public static String url =  "jdbc:mysql://localhost:3306/EducationSystem?serverTimezone=UTC";
    public static String user = "root";
    public static String password = "980727";

    public static Connection getConn () {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭连接

     */
    public static void close (PreparedStatement preparedState, Connection conn) {
        if (preparedState != null) {
            try {
                preparedState.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close (ResultSet rs, PreparedStatement preparedState, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedState != null) {
            try {
                preparedState.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接
     * @param state
     * @param conn
     */
    public static void close (Statement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close (ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql ="select * from user";
        preparedStatement = conn.prepareStatement(sql);
        rs = preparedStatement.executeQuery();
        if(rs.next()){
            System.out.println("数据库为空");
        }
        else{
            System.out.println("数据库不为空");
        }
    }
}