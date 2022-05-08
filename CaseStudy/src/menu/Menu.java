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
                1. Dang nhap                            |
                0. Thoat                                |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Dang nhap");
                System.out.println("Nhap vao UserName: ");
                String username = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Nhap vao PassWord: ");
                String password = scanner.nextLine();
                if (username.equals("admin") && password.equals("123"))
                    manageUser.login(username, password);
                System.out.println("Dang nhap thanh cong");
                menuProduct();
                break;

            case 2:
                System.exit(0);

        }

    }

    public void menuAccount() {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1. Xem thong tin                        |
                2. Doi Mat khau                         |   
                0. Log Out                              |
                                                        |
                Moi nhap lua chon                       |
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
                System.out.println("Nhap mat khau moi: ");
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
                1. Hien thi san pham                    |
                2. Them san pham                        |
                3. Sua san pham                         |
                4. Xoa san pham                         |
                5. Tim kiem san pham                    |
                6. Hien thi danh sach don hang          |
                                                        |
                0. Thoat                                |
                                                        |
                Nhap vao lua chon tu 1-6, 0 de thoat    |
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
                System.exit(0);

        }

    }

    public void menuShow() {
        manageProduct.display();
        menuProduct();
    }

    public void menuAdd() {
        System.out.println("Nhap ma Sp: ");
        int productId1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap ten Sp: ");
        String productName = scanner.nextLine();

        System.out.println("Nhap ngay san xuat: ");
        int manufactureDate = scanner.nextInt();
        System.out.println("Nhap han su dung: ");
        int expireDate = scanner.nextInt();
        System.out.println("Nhap so luong: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap mo ta san pham: ");
        String description = scanner.nextLine();

        manageProduct.add(new Product(productId1, productName, manufactureDate, expireDate, quantity, description));
        System.out.println("Da them thanh cong!");
        menuProduct();
    }

    public void menuEdit() {
        System.out.println("Nhap vao ma hang hoa can sua: ");
        int editId = scanner.nextInt();
        int a = manageProduct.findIndexById(editId);
        if (a != -1) {
            System.out.println("Nhap ma san pham: ");
            int productId2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap ten Sp: ");
            String productName = scanner.nextLine();
            System.out.println("Nhap ngay san xuat: ");
            int manufactureDate = scanner.nextInt();
            System.out.println("Nhap han su dung: ");
            int expireDate = scanner.nextInt();
            System.out.println("Nhap so luong: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhap mo ta san pham: ");
            String description = scanner.nextLine();
            manageProduct.edit(editId, new Product(productId2, productName, manufactureDate, expireDate, quantity, description));
            menuProduct();
        } else {
            System.out.println("Khong tim thay ma san pham");
        }
        menuProduct();
    }

    public void menuDelete() {
        System.out.println("Nhap ma san pham muon xoa: ");
        scanner.nextLine();
        int productId = scanner.nextInt();
        System.out.println("Xoa san pham thanh cong");
        manageProduct.delete(productId);
    }

    public void menuFindById() {
        System.out.println("Nhap vao ma san pham muon tim kiem: ");
        scanner.nextLine();
        int productId = scanner.nextInt();
        int a = manageProduct.findIndexById(productId);
        if (a != -1) {
            System.out.println(manageProduct.getProductList().get(a));
        } else {
            System.out.println("Khong tim thay ma san pham");
        }
        menuProduct();

    }


}
