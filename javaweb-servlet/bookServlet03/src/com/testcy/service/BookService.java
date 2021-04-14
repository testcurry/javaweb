package com.testcy.service;

import com.testcy.pojo.Book;
import com.testcy.pojo.User;

import java.util.List;

public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryAllBooks();

}
