package file;

import model.User;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WriteAndReadFile {
    String filePath = "/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/FinalExam_MD2/src/file/User.csv";

    public List<User> readFileUser(String s, List<User> userList) {
        try {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            userList.clear();
            if (scanner.nextLine() != null) {
                while (scanner.hasNext()) {
                    String a = scanner.nextLine();
                    String[] arr = a.split(",");
                    User user = new User(arr[0], Integer.parseInt(arr[1]), arr[2], arr[3], arr[4], Integer.parseInt(arr[5]), arr[6]);
                    userList.add(user);
                }
            } else {
                throw new Exception();

            }
        } catch (Exception e) {

        }
        return userList;
    }

    public void writeFileUser(String s, List<User> userList) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "NAME , PHONENUMBER,GROUP, GENDER, ADDRESS, DATEOFBIRTH , EMAIL \n";
        for (User u : userList) {
            line += u.getName() + ","
                    + u.getPhoneNumber() + ","
                    + u.getGroup() + ","
                    + u.getGender() + ","
                    + u.getAddress() + ","
                    + u.getDateOfBirth() + ","
                    + u.getEmail() + "\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }
}
