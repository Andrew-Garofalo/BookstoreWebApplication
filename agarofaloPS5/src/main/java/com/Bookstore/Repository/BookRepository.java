package com.Bookstore.Repository;

import com.Bookstore.Model.Book;
import com.Bookstore.Model.Genre;

import java.util.List;

public interface BookRepository {

    List<Book> findAllBooks();

    List<Book> findAllBooksByBookAuthor(String search);

    Book findBookByID(Long bookId);

    void deleteBook(Long bookId);

    Book addBook(String title, Long isbn, String author, String date, Genre genre, Double price);

    Book editBook(Long bookId, String title, Long isbn, String author, String date, Genre genre, Double price);
}
