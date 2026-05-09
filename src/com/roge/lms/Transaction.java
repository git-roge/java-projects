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

    public int getUserId(){ return this.userId;}

    public int getBookId() { return this.bookId;}

    @Override
    public String toString() {
        return String.format("transactionId: %d, bookId: %d, userId: %d",
                this.transactionId, this.bookId, this.userId
                );
    }
}
