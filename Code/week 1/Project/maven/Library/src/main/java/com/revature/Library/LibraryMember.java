package com.revature.Library;
import java.util.HashSet;

public class LibraryMember {
    String name;
    int id;

    String address;

    HashSet<Book> books;
    public LibraryMember(String name, String address, int id) {
        this.name = name;
        this.id = id;
        this.address = address;

    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}