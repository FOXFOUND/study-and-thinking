package com.foxfound.log.util;

import java.sql.*;

/**
 * @Description
 * @Author foxFound
 * @Date 2019-03-15
 */
public class DBUtil {
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static Connection getConnection() {
        String url = "jdbc:mysql://rm-2ze612h7947fcb7lz.mysql.rds.aliyuncs.com:3306/friendsay?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String user = "linkedme";
        String password = "LinkedME@wfc";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet executeQuery(String sql) {
        if (getConnection() == null) {
            return null;
        }
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet executeQuery(String sql, Object[] obj) {
        if (getConnection() == null) {
            return null;
        }
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void dbClose() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
    }
}