package com.revature.Library;
import java.util.HashSet;

public class LibraryMember {
    String name;
    int id;
    int numBooks;
    HashSet<Book> books;
    public LibraryMember(String name, int id) {
        this.name = name;
        this.id = id;
        this.numBooks = 0;

    }
    public void setBook(Book book) {
        books.add(book);
    }
    public HashSet<Book> getBooks() {
        return this.books;
    }
}