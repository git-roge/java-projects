package com.roge.lms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final int userId;
    private String userName;
    private final List<Book> borrowedBooks = new ArrayList<>();
    public User(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId(){return this.userId;}

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public void addBorrowedBooks(Book book){
        this.borrowedBooks.add(book);
    }

    public void removeBorrowedBooks(Book book){
        this.borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(this.borrowedBooks);
    }

    @Override
    public String toString() {
        return String.format(
                "User{userId: %d, userName: '%s}",
                this.userId, this.userName
        );
    }
}
