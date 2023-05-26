package com.revature.bookstore.service;

import com.revature.bookstore.entity.Book;
import com.revature.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> DisplayBooks() {
        return bookRepository.findAll();
    }
    public String deleteBook(Long id) {
        if (bookRepository.findById(id).isEmpty()) {
            return "Book not found";
        } else {
            bookRepository.deleteById(id);
            return "Book deleted";
        }

    }

    public String updateBook(Long id, String title, String author, String description) {
        if (bookRepository.findById(id).isEmpty()) {
            return "Book not found";
        } else {
            Book book = bookRepository.findById(id).get();
            book.setTitle(title);
            book.setAuthor(author);
            book.setDescription(description);
            bookRepository.save(book);
            return "Book updated";
        }

    }
}
