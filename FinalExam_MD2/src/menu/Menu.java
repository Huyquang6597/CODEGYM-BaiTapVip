package menu;

import file.WriteAndReadFile;
import input.CheckRegex;
import manage.ManageUser;
import model.User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    ManageUser manageUser = new ManageUser();
    WriteAndReadFile writeAndReadFile = new WriteAndReadFile();
    CheckRegex checkRegex = new CheckRegex();


    String str;
    int choice;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void menuMain() throws IOException {
        str = """
                ---PROGRAM TO MANAGE CONTACTS---|
                --------------------------------|
                1. Display list                 |
                2. Add                          |
                3. Edit                         |
                4. Delete                       |
                5. Search                       |
                6. Read from file               |
                7. Write to file                |
                8. Exit                         |
                                                |
                --------------------------------|
                """;
        System.out.println(str);
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > 8) {
                System.out.println("This function is not available, please re-enter the selection !");
                menuMain();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers 1 to 8 to access the function !");
            scanner.nextLine();
            choice = -1;
            menuMain();
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
                menuSearch();
                break;
            case 6:
                menuReadFromFile();
                break;
            case 7:
                menuWriteToFile();
                break;
            case 8:
                System.exit(8);
                break;
        }
    }

    public void menuShow() throws IOException {
        manageUser.display();
        menuMain();
    }

    public void menuAdd() throws IOException {

        try {
            System.out.println("Enter Phone number to add :");
            int phoneNumber = Integer.parseInt(checkRegex.checkPhoneNumber());
//            scanner.nextLine();
            System.out.println("Enter name :");
            String name = scanner.nextLine();
            System.out.println("Enter group: ");
            String group = scanner.nextLine();
            System.out.println("Enter gender :");
            String gender = scanner.nextLine();
            System.out.println("Enter address :");
            String address = scanner.nextLine();
            System.out.println("Enter Date of birth :");
            int dateOfBirth = scanner.nextInt();
//            scanner.nextLine();
            System.out.println("Enter email :");
            String email = checkRegex.checkEmail();
            User user = new User(name, phoneNumber, group, gender, address, dateOfBirth, email);
            manageUser.add(user);
            System.out.println("Successfully added !");
            menuMain();

        } catch (Exception e) {
            System.out.println("Enter wrong format, please enter the correct number format !");
            scanner.nextLine();
            menuAdd();
        }
    }


    public void menuDelete() {
        try {
            System.out.println("Enter phone number to delete: ");
            int phoneNumber = scanner.nextInt();
            manageUser.delete(phoneNumber);
//            writeAndReadFile.writeFileUser("/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/FinalExam_MD2/src/file/User.csv", manageUser.getUserList());
            scanner.nextLine();
            menuMain();
        } catch (Exception e) {
            System.out.println("Enter wrong format, please enter the correct number format !");
            scanner.nextLine();
            menuDelete();
        }
    }

    public void menuSearch() {
        try {
            System.out.println("Enter phone number to search: ");
            int phoneNumber = scanner.nextInt();
            int a = manageUser.findIndexByPhoneNumber(phoneNumber);
            if (a != -1) {
                System.out.println(manageUser.getUserList().get(a));
//                writeAndReadFile.writeFileUser("/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/FinalExam_MD2/src/file/User.csv", manageUser.getUserList());
            } else {
                System.out.println("No phone number found !");
            }
            menuMain();
        } catch (Exception e) {
            System.out.println("Enter wrong format, please enter the correct number format !");
            scanner.nextLine();
            menuSearch();
        }
    }

    public void menuEdit() throws IOException {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Enter Phone number to edit :");
                int editPhoneNumber = scanner.nextInt();
                int a = manageUser.findIndexByPhoneNumber(editPhoneNumber);
                if (a != -1) {
                    System.out.println("Enter name :");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter group: ");
                    String group = scanner.nextLine();
                    System.out.println("Enter gender :");
                    String gender = scanner.nextLine();
                    System.out.println("Enter address :");
                    String address = scanner.nextLine();
                    System.out.println("Enter Date of birth :");
                    int dateOfBirth = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter email :");
                    String email = checkRegex.checkEmail();
                    User user = new User(name, editPhoneNumber, group, gender, address, dateOfBirth, email);
                    manageUser.edit(editPhoneNumber, user);
                    menuMain();
                } else {
                    System.out.println("No phone number found !");
                }
                menuMain();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Enter wrong format, please enter the correct number format !");
                scanner.nextLine();
            }
        }
    }

    public void menuReadFromFile() throws IOException {
        writeAndReadFile.readFileUser("/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/FinalExam_MD2/src/file/User.csv", manageUser.getUserList());

        menuMain();

    }

    public void menuWriteToFile() throws IOException {
        writeAndReadFile.writeFileUser("/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/FinalExam_MD2/src/file/User.csv", manageUser.getUserList());
        System.out.println("Successfully added !");
        menuMain();
    }
}
