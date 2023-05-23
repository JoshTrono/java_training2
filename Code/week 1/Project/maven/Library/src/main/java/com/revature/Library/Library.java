package com.revature.Library;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void addMember(LibraryMember member) {
        members.add(member);
    }
    public void printBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
//    public void printMembers() {
//        System.out.println("Members of the library:");
//        for (LibraryMember member : members) {
//            System.out.println(member.getName());
//        }
    }
