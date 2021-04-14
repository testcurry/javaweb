package com.testcy.test;

import com.testcy.pojo.Book;
import com.testcy.service.BookService;
import com.testcy.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "从入门到放弃", "Tom", BigDecimal.valueOf(59.99), 1000101, 0, null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(26);
    }

    @Test
    public void updateBook() {
        Book book = new Book(23, "从入门到精通", "Tom", BigDecimal.valueOf(66.99), 123456, 110, null);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(24);
        System.out.println(book);
    }

    @Test
    public void queryAllBooks() {
        List<Book> books = bookService.queryAllBooks();
        for (Book book:books){
            System.out.println(book);
        }
    }
}