package com.roge.lms;

import java.util.*;

public class Library {
    private int bookId;
    private int userId;
    private int transactionId;
    private String libraryName;
    private final Map<Integer, Book> bookList = new HashMap<>();
    private final Map<Integer, User> userList = new HashMap<>();
    private final List<Transaction> transactionList = new ArrayList<>();

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
        Book newBook = new Book(++this.bookId, title, author, year);
        bookList.put(this.bookId, newBook);
    }

    public Map<Integer, Book> getBookList() {
        return Collections.unmodifiableMap(this.bookList);
    }

    public void removeBook(int bookId){
        bookList.remove(bookId);
    }

    public void addUser(String userName){
        User newUser = new User(++this.userId, userName);
        userList.put(this.userId, newUser);
    }

    public Map<Integer, User> getUserList(){
        return Collections.unmodifiableMap(this.userList);
    }

    public void removeUser(int userId){
        userList.remove(userId);
    }

    public void borrowBook(int bookId, int userId){
        Book book = bookList.get(bookId);
        User user = userList.get(userId);

        if(user.getBorrowedBooks().contains(book)){
            System.out.printf("\n%s already borrowed this book.\n", user.getUserName());
            return;
        }
        if(book.getStatus() == Status.BORROWED){
            System.out.println("Book is borrowed.");
            return;
        }
        book.setStatus(Status.BORROWED);

        user.addBorrowedBooks(book);

        Transaction transaction = new Transaction(++this.transactionId, bookId, userId);

        transactionList.add(transaction);
        System.out.println("Book has borrowed successfully.");
    }

    public void returnBook(int returnBookId, int returnUserId){
        Book book = bookList.get(returnBookId);
        User user = userList.get(returnUserId);

        if(!user.getBorrowedBooks().contains(book)){
            System.out.printf("\n%s didn't borrow this book. Please check the book Id.\n", user.getUserName());
            return;
        }

        book.setStatus(Status.AVAILABLE);
        user.removeBorrowedBooks(book);
        System.out.println("Book has returned.");
    }

    public boolean validateUser(int userId){
        User user = userList.get(userId);

        return user != null;
    }

    public boolean validateBook(int bookId){
        Book book = bookList.get(bookId);

        return book != null;
    }

    public List<Transaction> getTransactionList(){
        return Collections.unmodifiableList(this.transactionList);
    }
}
