package object;

public class OrderDetail {
    Product product = new Product();

    private String customerName;
    private String phoneNumber;
    private String email;

    public OrderDetail() {
    }

    public String p() {
        return product.getProductid() + " " + product.getProductName() + " " + product.getQuantity();
    }

    public OrderDetail(String customerName, String phoneNumber, String email) {

        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + p() +
                " Customer Name: '" + customerName + '\'' +
                ", Phone Number: '" + phoneNumber + '\'' +
                ", Email: '" + email + '\'' +
                '}';
    }
}

