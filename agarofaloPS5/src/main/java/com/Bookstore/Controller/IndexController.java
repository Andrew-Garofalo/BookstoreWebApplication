package com.Bookstore.Controller;

import com.Bookstore.Model.Book;
import com.Bookstore.Model.DateTime;
import com.Bookstore.Model.Genre;
import com.Bookstore.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

        @Autowired
        private BookService bookService;

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @PostMapping(value = "/")
    public String filteredIndexPage(@RequestParam String filterName, Model model) {
        List<Book> bookList = bookService.findAllBooksByBookAuthor(filterName);
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping(value = "/search")
    public String search(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);

        return "search";
    }


    @GetMapping(value = "/admin/books/view")
    public String viewPage(Model model) {
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "view";
    }

        //
        //  Remove Book
        @GetMapping(value = "/admin/books/delete/{bookId}")
        public String deleteBook(@PathVariable(value = "bookId") Long bookId) {

                if (bookId == null || bookId <= 0) {
                        throw new IllegalStateException("book ID is required!");
                }

                // delete the book by id
                bookService.deleteBook(bookId);

                return "redirect:/";
        }

        //
        // Add Book
        @GetMapping(value = "/admin/books/add")
        public String addBookPage() {
        return "addbook";
        }

        @PostMapping(value = "/admin/books/add")
        public String addBookForm(@RequestParam Long bookId, @RequestParam String title, @RequestParam Long isbn,
                              @RequestParam String author, @RequestParam String date, @RequestParam Genre genre,
                              @RequestParam Double price) {
            bookService.addBook(title, isbn, author, date, genre, price);
            return "redirect:/";}

        //
        // Edit Book
        @GetMapping(value = "/admin/books/edit/{bookId}")
        public String editBookPage(@PathVariable(value = "bookId") Long bookId, Model model) {

        if (bookId == null || bookId <= 0) {
            throw new IllegalStateException("Book ID is required!");
        }

        //
        //  Attempt to find the game
        Book book = bookService.findBookByID(bookId);
        if (book != null) {
            model.addAttribute("bookId", book.getBookId());
            model.addAttribute("title", book.getTitle());
            model.addAttribute("isbn", book.getIsbn());
            model.addAttribute("author", book.getAuthor());
            model.addAttribute("date", book.getDate());
            model.addAttribute("genre", book.getGenre());
            model.addAttribute("price", book.getPrice());
        }

        return "editbook";
    }

        @PostMapping(value = "/admin/books/editbook")
        public String editBookForm(@RequestParam Long bookId, @RequestParam String title, @RequestParam Long isbn,
                                   @RequestParam String author, @RequestParam String date, @RequestParam Genre genre,
                                   @RequestParam Double price) {
            bookService.editBook(bookId, title, isbn, author, date, genre, price);
            return "redirect:/";
    }

}

