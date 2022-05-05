package user;

public class Employee {
    private int id;
    private String userName;
    private String password;
    private int phoneNumber;
    private String address;
    private String email;
    private String employeeName;
    private int age;
    private int salary;
    private boolean status;

    public Employee() {
    }

    public Employee(int id, String userName, String password, int phoneNumber, String address, String email, String employeeName, int age, int salary, boolean status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.employeeName = employeeName;
        this.age = age;
        this.salary = salary;
        this.status = status;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Ma nhan vien: " + id +
                ", Ten dang nhap'" + userName + '\'' +
                ", Mat khau: '" + password + '\'' +
                ", So DT: " + phoneNumber +
                ", Dia chi: '" + address + '\'' +
                ", email: '" + email + '\'' +
                ", Ten nhan vien: '" + employeeName + '\'' +
                ", Tuoi: " + age +
                ", Muc luong: " + salary +
                ", Trang thai lam viec: " + status +
                '}';
    }
}
