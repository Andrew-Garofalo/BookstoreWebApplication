package com.Bookstore.Service;

import com.Bookstore.Model.ApplicationUser;
import com.Bookstore.Model.Book;
import com.Bookstore.Model.DateTime;
import com.Bookstore.Model.Genre;
import com.Bookstore.Model.Security.SecurityUser;
import com.Bookstore.Service.impl.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    List<Book> findAllBooksByBookAuthor(String search);

    Book findBookByID(Long bookId);

    void deleteBook(long bookId);

    Book addBook(String title, Long isbn, String author, String date, Genre genre, Double price);

    Book editBook(Long bookId, String title, Long isbn, String author, String date, Genre genre, Double price);

    @Repository
    class MobyDickUserDetailsService implements UserDetailsService {
        @Autowired
        private ApplicationUserService applicationUserService;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            ApplicationUser user = applicationUserService.findUserByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("Username not found: " + username);
            }
            return new SecurityUser(user);
        }
    }
}
