package com.Bookstore.Bootstrap;

import com.Bookstore.Model.Genre;
import com.Bookstore.Repository.ApplicationUserRepository;
import com.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //
        //  Add some users!
        applicationUserRepository.addUser("admin", "123", Boolean.TRUE);
        applicationUserRepository.addUser("user", "1234", Boolean.FALSE);
        applicationUserRepository.addUser("mark", "zuckerberg", Boolean.FALSE);

        //populate database with initial books
        bookRepository.addBook("Moby Dick", 1233548485L, "Herman Melville", new String("02/01/1974"), Genre.CLASSICS, 55.99);
        bookRepository.addBook("Dancing Queen, Behind the Scenes", 848645545L, "Abba", new String("08/10/1998"), Genre.NONFICTION, 100.20);
        bookRepository.addBook("Chemistry 3rd Edition", 695948847L, "Albert Einstein", new String("05/25/1914"), Genre.NONFICTION, 42.15);
        bookRepository.addBook( "50 Shades of Java", 1233548485L, "Stephanie Meier", new String("11/18/2017"), Genre.ROMANCE, 5.99);
    }
}
