package com.Bookstore.Repository.Impl;

import com.Bookstore.Model.Book;
import com.Bookstore.Model.DateTime;
import com.Bookstore.Model.Genre;
import com.Bookstore.Repository.BookRepository;
import com.Bookstore.jpa.BookCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookRepositoryImplementation implements BookRepository{

    @Autowired
    BookCrudRepository bookCrudRepository;

    @Override
    public List<Book> findAllBooks() {
         return (List<Book>) bookCrudRepository.findAll();
    }


    @Override
    public List<Book> findAllBooksByBookAuthor(String search) {
        return  bookCrudRepository.findByAuthor(search);
    }

    @Override
    public Book findBookByID(Long bookId) {
        return bookCrudRepository.findOne(bookId);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookCrudRepository.delete(bookId);
    }


    @Override
    public Book addBook(String title, Long isbn, String author, String date, Genre genre, Double price) {
        Book toAdd = new Book(title, isbn, author, date, genre, price);

        return bookCrudRepository.save(toAdd);
    }

    @Override
    public Book editBook(Long bookId, String title, Long isbn, String author, String date, Genre genre, Double price) {
        // find book by id
        Book candidate = bookCrudRepository.findOne(bookId);
        if (candidate == null) {
            return null;
        } else {
            candidate.setTitle(title);
            candidate.setIsbn(isbn);
            candidate.setAuthor(author);
            candidate.setDate(date);
            candidate.setGenre(genre);
            candidate.setPrice(price);
            return bookCrudRepository.save(candidate);
        }
    }
}
