package com.testcy.dao;

import com.testcy.pojo.Book;

import java.util.List;

public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(int begin,Integer pageSize);

    List<Book> queryForPriceItems(int begin,Integer pageSize,Integer min, Integer max);

    Integer queryForPageTotalByPrice(Integer min, Integer max);
}
