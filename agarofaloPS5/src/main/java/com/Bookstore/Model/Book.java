package com.Bookstore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class Book {

    /*
        Instance Data
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 100)
    private Long bookId;
    private String title;
    private Long isbn;
    private String author;
    private String date;

    @Enumerated(EnumType.STRING)
    Genre genre;
    Double price;

    public Book(){

    }

    public Book(String title, Long isbn, String author, String date, Genre genre, Double price) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.date = date;
        this.genre = genre;
        this.price = price;
    }

    public Book(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", genre=" + genre +
                ", price=" + price +
                '}';
    }
}
