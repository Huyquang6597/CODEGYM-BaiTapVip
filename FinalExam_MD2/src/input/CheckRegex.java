package input;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckRegex {
    public String checkSoDT () {
        Scanner sc = new Scanner(System.in);
        String phoneNumber = "";
        while (true) {
            System.out.println("Enter your phone number :");
            System.out.println( "Note: The phone number must start from 0 and the number of numbers in the range (6-11)");
            phoneNumber = sc.nextLine();
            Pattern pNumber = Pattern.compile("^.*[0]+.*$");
            Pattern pLength = Pattern.compile("^.{6,11}$");

            if (pNumber.matcher(phoneNumber).find() && pLength.matcher(phoneNumber).find()) {
                break;
            } else {
                System.out.println("Incorrect phone number format entered !");
            }
        }
        return phoneNumber;
    }

    public String checkEmail () {
        Scanner sc = new Scanner(System.in);
        String mail = "";
        while (true) {
            System.out.println("Enter email :");
            System.out.println("(Note: Must start with a letter)");
            mail = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$");

            if (p.matcher(mail).find()) {
                break;
            } else {
                System.out.println( "Enter incorrect email format !");
            }
        }
        return mail;
    }
}
