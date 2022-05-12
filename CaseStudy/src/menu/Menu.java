package menu;

import account.User;
import file.FileProductCSV;
import file.FileUserCSV;
import manage.ManageProduct;
import object.Product;
import manage.ManageUser;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    ManageProduct manageProduct = new ManageProduct();
    ManageUser manageUser = new ManageUser();
    FileUserCSV fileUserCSV = new FileUserCSV();
    FileProductCSV fileProductCSV = new FileProductCSV();

    String str;
    int choice;
    Scanner scanner = new Scanner(System.in);

    public Menu() throws FileNotFoundException {
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
        try {
            choice = scanner.nextInt();

            if (choice < 0 || choice > 2) {
                System.out.println("This function is not available, please re-enter the selection !");
                menuMain();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers 0 to 2 to access the function !");
            scanner.nextLine();
            choice = -1;
            menuMain();
        }
        switch (choice) {
            case 1:
                System.out.println("Registration");
                System.out.println("Enter UserName: ");
                scanner.nextLine();
                String usn = scanner.nextLine();
                for (User user :
                        manageUser.getUserList()) {
                    if (user.getUserName().equals(usn)) {
                        System.out.println("Already have this username, please enter another username ");
                        menuMain();
                    }
                }

                System.out.println("Enter PassWord: ");
                String pass = scanner.nextLine();
                manageUser.add(new User(usn, pass));
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
                if (manageUser.login(username, password) != 1) {
                    System.out.println("Wrong information entered, please re-enter !");
                    menuMain();
                } else {
                    menuAccount();
                }
                break;

            default:
                System.exit(0);

        }

    }

    public void menuAccount() throws IOException {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Display Information                  |
                2. Change Password                      |
                3. Access to main system                |   
                0. Log Out                              |
                                                        |
                Please enter options                    |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 0 || choice > 3) {
                System.out.println("This function is not available, please re-enter the selection !");
                menuAccount();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers 0 to 3 to access the function !");
            scanner.nextLine();
            choice = -1;
            menuAccount();
        }
        switch (choice) {
            case 1:

                manageUser.display();
                menuAccount();
                break;
            case 2:
                System.out.println("Enter User name: ");

                String usn1 = scanner.nextLine();

                int b = manageUser.findByName(usn1);
                if (b != -1) {
                    System.out.println("Enter new Passwpord: ");
                    String newPass = scanner.nextLine();
                    manageUser.getUserList().get(b).setPassWord(newPass);
                    System.out.println("Change password successfully");
                    fileUserCSV.writeFileUser(manageUser.getUserList());
                    menuAccount();
                } else {
                    System.out.println("No User Name found !");
                    menuAccount();
                }

                break;
            case 3:
                menuProduct();
                break;
            default:
                menuMain();
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
                                                        |
                0. Exit                                 |
                                                        |
                Please enter options                    |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 0 || choice > 5) {
                System.out.println("This function is not available, please re-enter the selection !");
                menuAccount();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers 0 to 3 to access the function !");
            scanner.nextLine();
            choice = -1;
            menuAccount();
        }
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

        try {
            System.out.println("Enter product Id: ");
            int productId1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.println("Enter product manufacture date: ");
            String manufactureDate = scanner.nextLine();
            System.out.println("Enter the expiration date: ");
            String expireDate = scanner.nextLine();
            System.out.println("Enter product quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter product description: ");
            String description = scanner.nextLine();
            Product product = new Product(productId1, productName, manufactureDate, expireDate, quantity, description);
            manageProduct.add(product);
            fileProductCSV.writeFileProduct(manageProduct.getProductList());
            System.out.println("Successfully added !");
            menuProduct();
        } catch (Exception e) {
            System.out.println("Enter wrong format, please enter the correct number format !");
            scanner.nextLine();
            menuAdd();

        }

    }

    public void menuEdit() throws IOException {
        boolean flag = true;
        while (flag) {
            try {
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
                    String manufactureDate = scanner.nextLine();
                    System.out.println("Enter the expiration date: ");
                    String expireDate = scanner.nextLine();
                    System.out.println("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product description: ");
                    String description = scanner.nextLine();
//                    manageProduct.edit(editId, new Product(productId2, productName, manufactureDate, expireDate, quantity, description));
                    Product product = new Product(productId2, productName, manufactureDate, expireDate, quantity, description);
                    manageProduct.edit(editId, product);
                    fileProductCSV.writeFileProduct(manageProduct.getProductList());
                    menuProduct();
                } else {
                    System.out.println("No product id found !");
                }
                menuProduct();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Enter wrong format, please enter the correct number format !");
                scanner.nextLine();
            }

        }
    }

    public void menuDelete() throws IOException {
        try {
            System.out.println("Enter product id to delete: ");
            int productId = scanner.nextInt();
            manageProduct.delete(productId);
            fileProductCSV.writeFileProduct(manageProduct.getProductList());
            scanner.nextLine();
            menuProduct();
        } catch (Exception e) {
            System.out.println("Enter wrong format, please enter the correct number format !");
            scanner.nextLine();
            menuDelete();
        }


    }

    public void menuFindById() throws IOException {
        try {
            System.out.println("Enter product id to search: ");
            int productId = scanner.nextInt();
            int a = manageProduct.findIndexById(productId);
            if (a != -1) {
                System.out.println(manageProduct.getProductList().get(a));
                fileProductCSV.writeFileProduct(manageProduct.getProductList());
            } else {
                System.out.println("No product id found !");
            }
            menuProduct();
        } catch (Exception e) {
            System.out.println("Enter wrong format, please enter the correct number format !");
            scanner.nextLine();
            menuFindById();
        }


    }


}
