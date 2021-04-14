package com.testcy.dao.impl;

import com.testcy.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
//org.apache.commons.dbutils.QueryRunner

import java.sql.Connection;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()用来执行update/insert/delete语句
     *
     * @return -1为未查到
     */
    public int update(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询返回一条JavaBean的方法
     *
     * @param type 需要查询的类型
     * @param sql  sql语句
     * @param args sql语句的占位符
     * @param <T>  返回的JavaBean的类型的泛型
     * @return
     * @throws Exception
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多条JavaBean的方法
     *
     * @param type 需要查询的类型
     * @param sql  sql语句
     * @param args sql语句的占位符
     * @param <T>  返回的JavaBean的类型的泛型
     * @return
     * @throws Exception
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回一个单行单列值得方法
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler<>(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

}
