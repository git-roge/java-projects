package com.roge.lms;

public class Book {
    private final int bookId;
    private String title;
    private String author;
    private int year;
    private Status status;

    public Book(int bookId, String title, String author, int year){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = Status.AVAILABLE;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Status getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return String.format(
          "Book{bookId=%d, title='%s', author='%s', year=%d, status='%s'}",
          this.bookId, this.title, this.author, this.year, this.status
        );
    }
}
