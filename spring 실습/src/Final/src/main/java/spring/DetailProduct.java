package spring;

public class DetailProduct {
    private int id;
    private String category;
    private String name;
    private int price;
    private int buying_count;
    private String photo;
    private String reg_time;

    public DetailProduct(int id, String category, String name, int price, int buying_count, String photo, String reg_time) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.buying_count = buying_count;
        this.photo = photo;
        this.reg_time = reg_time;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getBuying_count() {
        return buying_count;
    }

    public String getPhoto() {
        return photo;
    }

    public String getReg_time() {
        return reg_time;
    }
}
