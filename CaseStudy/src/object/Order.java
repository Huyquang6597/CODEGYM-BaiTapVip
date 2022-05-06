package object;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderDetail> orderDetailList = new ArrayList<>();


    private int id;
    private String customerName;
    private String phoneNumber;
    private String email;

    public Order() {
    }

    public Order(int id, String customerName, String phoneNumber, String email) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
