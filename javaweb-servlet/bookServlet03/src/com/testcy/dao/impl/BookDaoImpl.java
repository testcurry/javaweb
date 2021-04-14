package com.testcy.dao.impl;

import com.testcy.dao.BookDao;
import com.testcy.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`)values(?,?,?,?,?,?)";
        int updateCount = update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        return updateCount;
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        int delCount = update(sql, id);
        return delCount;
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=? ,author=?, price=?, sales=?, stock=? ,img_path=? where id=?";
        int updateCount = update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
        return updateCount;
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id=?";
        Book book = queryForOne(Book.class, sql, id);
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book ";
        List<Book> bookList = queryForList(Book.class, sql);
        return bookList;
    }
}
