package com.testcy.test;

import com.testcy.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    @Test
    public void testConn() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
//        JDBCUtils.close(connection);
    }
}
