package spring;

import java.sql.Date;

public class SearchBuyingProductDto {
    private int id;
    private String category;

    private String name;

    private int price;

    private Date buyingDate;

    public SearchBuyingProductDto(int id, String category, String name, int price, Date buyingDate) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.buyingDate = buyingDate;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

}
