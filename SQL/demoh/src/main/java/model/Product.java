package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int categoryId;
    private String description;
    private String color;
    private Category category;


    public Product() {
    }

    public Product(int id, String name, double price, int quantity, int categoryId, String description, String color, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.description = description;
        this.color = color;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
