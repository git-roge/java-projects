package com.roge.lms;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private int bookId;
    private String libraryName;
    private final Map<Integer, Book> bookList = new HashMap<>();

    public Library(String libraryName){
        this.libraryName = libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void addBook(String title, String author, int year){
        Book newBook = new Book(++bookId, title, author, year);
        bookList.put(bookId, newBook);
    }

    public Map<Integer, Book> getBookList() {
        return bookList;
    }

    public void removeBook(int bookId){
        bookList.remove(bookId);
    }
}
