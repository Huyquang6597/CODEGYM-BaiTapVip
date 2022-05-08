package file;

import account.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class ReađAnWrite {


    public void readFile(List<User> userList ,String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        Scanner scanner = new Scanner(fileReader);
        userList.clear();
        if(scanner.nextLine() != null){
            while (scanner.hasNext()){
                String a = scanner.nextLine();
                String []arr = a.split(",");

            }
        }


    }
}
