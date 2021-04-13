package com.testcy.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {

    private static DruidDataSource dataSource;

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


    public static Connection getConnection() {
        Connection conn=null;
        try {
             conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection connection) {
        try {
            if (connection!=null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
