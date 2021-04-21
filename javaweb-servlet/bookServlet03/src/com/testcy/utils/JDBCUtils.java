package com.testcy.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.Console;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DruidDataSource dataSource;
    public static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
//            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = conns.get();
        try {
            if (conn == null) {
                conn = dataSource.getConnection();
                conns.set(conn);//保存到ThreadLocal对象中，供后面的jdbc操作使用
                conn.setAutoCommit(false);//设置为手动管理事务
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 提交事务并关闭释放连接
     *
     */
    public static void commitAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        conns.remove();
    }

    /**
     * 回滚并关闭释放连接
     *
     */
    public static void rollbackAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                if (conn!=null){
                    try {
                        conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }
        conns.remove();
    }

    /**
     * 关闭数据库链接
     * @param connection
     */
    /*
    public static void close(Connection connection) {
        try {
            if (connection!=null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    */
}
