package entity;

import java.time.LocalDate;

public class Invoice extends AbstractEntity{

    private User user;
    private Book book;
    private double amount;
    private LocalDate date;

    public Invoice(int id, User user, Book book, double amount, LocalDate date) {
        super(id);
        this.user = user;
        this.book = book;
        this.amount = amount;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}