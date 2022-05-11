package object;

public class Product {
    private  int productid;
    private String productName;
    private String manufactureDate; //ngày sx
    private String expireDate;
    private int quantity;
    private String description;

    public Product() {
    }

    public Product(int productid, String productName,  String manufactureDate, String expireDate, int quantity, String description) {
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


    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
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
                "Product Id: " + productid +
                ", Product name: '" + productName + '\'' +
                ", Product manufacture date: " + manufactureDate +
                ", Product expiration date: " + expireDate +
                ", Product quantity: " + quantity +
                ", Product description: '" + description + '\'' +
                '}';
    }
}
