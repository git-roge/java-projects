package com.roge.lms;

public class Transaction {
    private final int transactionId;
    private int bookId;
    private int userId;

    public Transaction(int transactionId, int bookId, int userId){
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
    }

    public void borrowBook(int transactionId){

    }
}
