package menu;

import manage.ManageProduct;
import object.Product;
import manage.ManageUser;


import java.util.Scanner;

public class Menu {
    ManageProduct manageProduct = new ManageProduct();
    ManageUser manageUser = new ManageUser();
    String str;
    int choice;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void menuMain() {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Log In                               |
                0. Exit                                 |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Log In ");
                System.out.println("Enter UserName: ");
                scanner.nextLine();
                String username = scanner.nextLine();
                System.out.println("Enter PassWord: ");
                String password = scanner.nextLine();
                if (username.equals("admin") && password.equals("123"))
                {
                    manageUser.login(username, password);
                    System.out.println("Logged in successfully");
                    menuProduct();
                } else {
                    System.out.println("Wrong account or password, please re-enter");
                }
                break;

            case 2:
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
        switch (choice){
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

    public void menuProduct() {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Display all products                 |
                2. Add new products                     |
                3. Edit products                        |
                4. Delete products                      |
                5. Search products                      |
                6. Hien thi danh sach don hang          |
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
            default:
                menuMain();

        }

    }

    public void menuShow() {
        manageProduct.display();
        menuProduct();
    }

    public void menuAdd() {
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

    public void menuEdit() {
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

    public void menuFindById() {
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


}
