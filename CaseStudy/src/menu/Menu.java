package menu;

import account.User;
import file.FileUserCSV;
import manage.ManageProduct;
import object.Product;
import manage.ManageUser;


import java.io.IOException;
import java.util.Scanner;

public class Menu {
    ManageProduct manageProduct = new ManageProduct();
    ManageUser manageUser = new ManageUser();
    FileUserCSV fileUserCSV = new FileUserCSV();

    String str;
    int choice;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void menuMain() throws IOException {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Registration                         |
                2. Log In                               |
                0. Exit                                 |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Registration");
                System.out.println("Enter UserName: ");
                scanner.nextLine();
                String usn = scanner.nextLine();
                System.out.println("Enter PassWord: ");
                String pass = scanner.nextLine();
                User user = new User(usn, pass);
                manageUser.add(user);
                fileUserCSV.writeFileUser(manageUser.getUserList());
                System.out.println("Sign Up Success !");
                menuMain();

                break;
            case 2:
                System.out.println("Log In ");
                System.out.println("Enter UserName: ");
                scanner.nextLine();
                String username = scanner.nextLine();
                System.out.println("Enter PassWord: ");
                String password = scanner.nextLine();
                if (manageUser.login(username, password) == 1) {
                    menuProduct();
                } else if(manageUser.login(username,password) != -1) {
                    System.out.println("You do not have an account, please register first !");
                    menuMain();

                } else {
                    System.out.println("Wrong username or password, please re-enter");
                    menuMain();
                }
                break;

            case 3:
                System.exit(0);

        }

    }

    public void menuAccount() {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Display Information                  |
                2. Change Password                      |   
                0. Log Out                              |
                                                        |
                Please enter options                    |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageUser.display();
                break;
            case 2:
                System.out.println("Enter new passwpord: ");
                scanner.nextLine();
                String newPass = scanner.nextLine();
                manageUser.currentUser.setPassWord(newPass);

                break;
            case 3:
                break;
        }
    }

    //order để lưu vào file
//display bill đọc file
    public void menuProduct() throws IOException {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Display all products                 |
                2. Add new products                     |
                3. Edit products                        |
                4. Delete products                      |
                5. Search products                      |
                6. Order                                | 
                7. Display the bill                     |
                                                        |
                0. Exit                                 |
                                                        |
                Enter selection from 1 to 6, 0 to exit  |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                menuShow();
                break;
            case 2:
                menuAdd();
                break;
            case 3:
                menuEdit();
                break;
            case 4:
                menuDelete();
                break;
            case 5:
                menuFindById();
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                menuMain();

        }

    }

    public void menuShow() throws IOException {
        manageProduct.display();
        menuProduct();

    }

    public void menuAdd() throws IOException {
        System.out.println("Enter product Id: ");
        int productId1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.println("Enter product manufacture date: ");
        int manufactureDate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the expiration date: ");
        int expireDate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        manageProduct.add(new Product(productId1, productName, manufactureDate, expireDate, quantity, description));
        System.out.println("Successfully added !");
        menuProduct();
    }

    public void menuEdit() throws IOException {
        System.out.println("Enter product id to edit: ");
        int editId = scanner.nextInt();
        int a = manageProduct.findIndexById(editId);
        if (a != -1) {
            System.out.println("Enter product Id: ");
            int productId2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.println("Enter product manufacture date: ");
            int manufactureDate = scanner.nextInt();
            System.out.println("Enter the expiration date: ");
            int expireDate = scanner.nextInt();
            System.out.println("Enter product quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter product description: ");
            String description = scanner.nextLine();
            manageProduct.edit(editId, new Product(productId2, productName, manufactureDate, expireDate, quantity, description));
            menuProduct();
        } else {
            System.out.println("No product id found !");
        }
        menuProduct();
    }

    public void menuDelete() {
        System.out.println("Enter product id to delete: ");
        scanner.nextLine();
        int productId = scanner.nextInt();
        System.out.println("Delete product successfully !");
        manageProduct.delete(productId);
    }

    public void menuFindById() throws IOException {
        System.out.println("Enter product id to search: ");
        scanner.nextLine();
        int productId = scanner.nextInt();
        int a = manageProduct.findIndexById(productId);
        if (a != -1) {
            System.out.println(manageProduct.getProductList().get(a));
        } else {
            System.out.println("No product id found !");
        }
        menuProduct();

    }

    public void menuOrder() {

    }

}
