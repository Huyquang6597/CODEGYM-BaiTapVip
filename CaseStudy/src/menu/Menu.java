package menu;

import manage.ManageProduct;

import java.util.Scanner;

public class Menu {
    ManageProduct manageProduct = new ManageProduct();
    String str;
    int choice;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void menuMain(){
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
        switch (choice){
            case 1:
            System.out.println("Dang ky");
                System.out.println("Nhap vao UserName: ");
                String username = scanner.nextLine();
                System.out.println("Nhap vao PassWord: ");
                String password = scanner.nextLine();

            break;
        }

    }

    public void menuProduct(){
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
    }
}
