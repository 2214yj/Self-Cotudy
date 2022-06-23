package spring;

public class SearchProductDto {
    private int id;
    private String category;

    private String name;

    private int price;

    public SearchProductDto(int id,String category, String name, int price) {
        this.id=id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }

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
}
