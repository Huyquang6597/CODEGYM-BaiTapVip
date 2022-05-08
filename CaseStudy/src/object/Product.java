package object;

public class Product {
    private  int productid;
    private String productName;
    private int manufactureDate; //ngày sx
    private int expireDate;
    private int quantity;
    private String description;

    public Product() {
    }

    public Product(int productid, String productName,  int manufactureDate, int expireDate, int quantity, String description) {
        this.productid = productid;
        this.productName = productName;
        this.manufactureDate = manufactureDate;
        this.expireDate = expireDate;
        this.quantity = quantity;
        this.description = description;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(int manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Ma san pham: " + productid +
                ", Ten san pham: '" + productName + '\'' +
                ", Ngay san xuat: " + manufactureDate +
                ", Han su dung: " + expireDate +
                ", So luong: " + quantity +
                ", Mo ta san pham: '" + description + '\'' +
                '}';
    }
}
