package controller;

public class BookInfo {
    private String name;
    private long price;
    private String publisher;

    public BookInfo( String name, String publisher, int price) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
