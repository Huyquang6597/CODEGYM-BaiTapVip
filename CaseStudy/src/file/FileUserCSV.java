package file;

import account.User;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileUserCSV {


    public List<User> readFileUser(List<User> userList, String filePath) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            userList.clear();
            if (scanner.nextLine() != null) {
                while (scanner.hasNext()) {
                    String a = scanner.nextLine();
                    String[] arr = a.split(",");
                    User user = new User(arr[0], arr[1]);
                    userList.add(user);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {

        }
        return userList;
    }

    public void writeFileUser (List<User> userList, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "USERNAME , PASSWORD \n";
        for (User u : userList){
            line += u.getUserName() + "," + u.getPassWord() + "\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }
}
