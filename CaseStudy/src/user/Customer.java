package user;

public class Customer {
    private int id;
    private String userName;
    private String password;
    private int phoneNumber;
    private String address;
    private String email;
    private String customerName;
    private int age;

    public Customer() {
    }

    public Customer(int id, String userName, String password, int phoneNumber, String address, String email, String customerName, int age) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.customerName = customerName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Ma khach hang: " + id +
                ", Ten dang nhap: '" + userName + '\'' +
                ", Mat khau: '" + password + '\'' +
                ", So DT: " + phoneNumber +
                ", Dia chi: '" + address + '\'' +
                ", email: '" + email + '\'' +
                ", Ten khach hang: '" + customerName + '\'' +
                ", Tuoi: " + age +
                '}';
    }
}
