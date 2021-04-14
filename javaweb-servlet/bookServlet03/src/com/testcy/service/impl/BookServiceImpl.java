package com.testcy.service.impl;

import com.testcy.dao.BookDao;
import com.testcy.dao.UserDao;
import com.testcy.dao.impl.BookDaoImpl;
import com.testcy.dao.impl.UserDaoImpl;
import com.testcy.pojo.Book;
import com.testcy.pojo.User;
import com.testcy.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        Book book = bookDao.queryBookById(id);
        return book;
    }

    @Override
    public List<Book> queryAllBooks() {
        List<Book> bookList = bookDao.queryBooks();
        return bookList;
    }
}
