package menu;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File("User.csv");
//        file.createNewFile();
        Menu menu  = new Menu();
        menu.menuMain();
    }
}
