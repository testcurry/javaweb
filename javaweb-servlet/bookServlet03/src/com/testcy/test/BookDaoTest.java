package com.testcy.test;

import com.testcy.dao.BookDao;
import com.testcy.dao.UserDao;
import com.testcy.dao.impl.BookDaoImpl;
import com.testcy.pojo.Book;
import com.testcy.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book(null, "从删库到跑路", "Curry", BigDecimal.valueOf(99.99), 9999999, 0, null));
        System.out.println("添加了"+i+"行数据！");
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(22);
        System.out.println("删除了"+i+"行数据！");
    }

    @Test
    public void updateBook() {
        Book newBook = new Book(23, "从入门到放弃", "Tom", BigDecimal.valueOf(59.99), 1000101, 0, null);
        int i = bookDao.updateBook(newBook);
        System.out.println("更新了"+i+"数据！");
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(9);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        Integer totalCount = bookDao.queryForPageTotalCount();
        System.out.println(totalCount);
    }


    @Test
    public void queryForPageItems(){
        //begig=(pageNo-1)*pageSize
        List<Book> books = bookDao.queryForPageItems(4, Page.PAGE_SIZE);
//        for (Book book:books){
//            System.out.println(book);
//        }
        books.forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        Integer totalCount = bookDao.queryForPageTotalByPrice(10,50);
        System.out.println(totalCount);
    }

    @Test
    public void queryForPageItemsByPrice(){
        //begig=(pageNo-1)*pageSize
        List<Book> books = bookDao.queryForPriceItems(0, Page.PAGE_SIZE,10,50);
//        for (Book book:books){
//            System.out.println(book);
//        }
        books.forEach(System.out::println);
    }
}