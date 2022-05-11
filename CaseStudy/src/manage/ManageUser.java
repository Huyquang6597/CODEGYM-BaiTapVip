package manage;

import account.User;
import file.FileUserCSV;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ManageUser {

    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
//    public static final String NOT_VALID_PASS_MESSAGE =
//            "Nhập Password chưa đúng định dạng!!!\n" +
//                    "Nhập lại Mật khẩu theo yêu cầu sau:\n" +
//                    "[Tối thiểu 8 ký tự gồm chữ hoa, chữ thường, ký tự số và ký tự đặc biệt] >>> ";


    FileUserCSV fileUserCSV = new FileUserCSV();
    private List<User> userList = new ArrayList<>();
//    private List<ManageUser> manageUserList = new ArrayList<>();
    public static User currentUser = null;
    int count = 0;

public ManageUser() throws FileNotFoundException {
    userList = fileUserCSV.readFileUser(userList);
}
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void add(User user) {
        userList.add(user);
    }

    public void display() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
//            check = true;
        }
//        if (check == false) {
//            System.out.println("Chua co tai khoan!");
//        }
    }

    public int login(String username, String password) {

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassWord().equals(password)) {
                    System.out.println("Logged in successfully");

                }
//                if (userList.get(i).getUserName().equals(username) || userList.get(i).getPassWord().equals(password)) {
//                    System.out.println("Enter wrong username or password, please re-enter !");
//                }
            }
        for (User user : userList) {
            if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                currentUser = user;
                return 1;
            }
        }
        return 0;
    }

    public void editUserName(String username, String password, User user) {
        if (count == 0) {
            System.out.println("You do not have an account, please register for an account first !");
        } else {
            int indexOfUserName = findByUserName(username, password);
            if (indexOfUserName == -1) {
                System.out.println("Enter the wrong username , please re-enter !");
            } else {
                userList.set(findByUserName(username, password), user);
                System.out.println("Change password successfull !");
            }
        }
    }

    public int findByUserName(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassWord().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    public int findByName(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(username) ) {
                return i;
            }
        }
        return -1;
    }
    public int findIndexById(int id) {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
            return i;
        }
        return -1;
    }

    public void edit(int id, User user) {
        userList.set(findIndexById(id), user);
    }

    public void delete(int id) {
        userList.remove(findIndexById(id));
    }

}
