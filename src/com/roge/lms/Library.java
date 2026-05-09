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
        if(!bookList.containsKey(bookId)){
            System.out.println("The selected book doesn't exist.");
            return;
        }

        if(!userList.containsKey(userId)){
            System.out.println("The selected user doesn't exist.");
            return;
        }

        Transaction transaction = new Transaction(++this.transactionId, bookId, userId);
        transactionList.add(transaction);

        for(Map.Entry<Integer, Book> entry : getBookList().entrySet()){
            if(entry.getKey() == bookId && entry.getValue().getStatus() == Status.AVAILABLE){
                entry.getValue().setStatus(Status.BORROWED);
            }
        }
    }

    public List<Transaction> getTransactionList(){
        return Collections.unmodifiableList(this.transactionList);
    }
}
