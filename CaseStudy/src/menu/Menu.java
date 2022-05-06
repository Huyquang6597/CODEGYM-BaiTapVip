package menu;

import manage.ManageProduct;
import object.Product;
import registerandlogin.ManageUser;
import registerandlogin.User;

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
                1. Dang ky                              |
                2. Dang nhap                            |
                                                        |
                ========================================|
                """;
        System.out.println(str);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Dang ky");
                System.out.println("Nhap vao UserName: ");
                String username = scanner.nextLine();
                System.out.println("Nhap vao PassWord: ");
                String password = scanner.nextLine();
                User user = new User(username, password);
                manageUser.add(user);
                break;

            case 2:
                System.out.println("Dang nhap");
                System.out.println("Nhap vao UserName: ");
                String usn = scanner.nextLine();
                System.out.println("Nhap vao PassWord: ");
                String pass = scanner.nextLine();
                manageUser.login(usn, pass);
                System.out.println("Dang nhap thanh cong");
                menuProduct();
                break;
        }

    }

    public void menuProduct() {
        str = """
                ==================Menu==================|
                ----------------------------------------|
                1 .Hien thi san pham                    |
                2. Them san pham                        |
                3. Sua san pham                         |
                4. Xoa san pham                         |
                5. Chinh sua thong tin nv               |
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

        }

    }

    public void menuShow() {
        manageProduct.display();
        menuProduct();
    }

    public void menuAdd() {
        System.out.println("Nhap ma Sp: ");
        int productId = scanner.nextInt();
        System.out.println("Nhap ten Sp: ");
        String productName = scanner.nextLine();
        System.out.println("Nhap ngay san xuat: ");
        int manufactureDate = scanner.nextInt();
        System.out.println("Nhap han su dung: ");
        int expireDate = scanner.nextInt();
        System.out.println("Nhap so luong: ");
        int quantity = scanner.nextInt();
        System.out.println("Nhap mo ta san pham: ");
        String description = scanner.nextLine();
        manageProduct.add(new Product(productId, productName, manufactureDate, expireDate, quantity, description));
        System.out.println("Da them thanh cong!");
        menuProduct();
    }

    public void menuEdit() {
        System.out.println();
    }

}
