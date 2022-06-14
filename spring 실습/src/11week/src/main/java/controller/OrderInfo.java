package controller;

import java.sql.Date;

public class OrderInfo {
    private Long custId;
    private Long bookId;
    private int price;
    private String date;

    public OrderInfo(int custId, int bookId, int price, String date) {
        this.custId = Long.valueOf(custId);
        this.bookId = Long.valueOf(bookId);
        this.price = price;
        this.date = String.valueOf(date);
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = String.valueOf(date);
    }


}
