package com.Bookstore.Service.impl;

import com.Bookstore.Model.Book;
import com.Bookstore.Model.Genre;
import com.Bookstore.Repository.BookRepository;
import com.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public List<Book> findAllBooksByBookAuthor(String search) {
        return bookRepository.findAllBooksByBookAuthor(search);
    }

    @Override
    public Book findBookByID(Long bookId) {
        return bookRepository.findBookByID(bookId);
    }

    @Override
    public void deleteBook(long bookId) {
        bookRepository.deleteBook(bookId);
    }

    @Override
    public Book addBook(String title, Long isbn, String author, String date, Genre genre, Double price) {
        return bookRepository.addBook(title, isbn, author, date, genre, price);
    }

    @Override
    public Book editBook(Long bookId, String title, Long isbn, String author, String date, Genre genre, Double price) {
        return bookRepository.editBook(bookId, title, isbn, author, date, genre, price);
    }
}
