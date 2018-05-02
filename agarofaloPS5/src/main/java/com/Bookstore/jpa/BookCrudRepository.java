package com.Bookstore.jpa;

import com.Bookstore.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
    List<Book> findByAuthor(String filterName);
}
