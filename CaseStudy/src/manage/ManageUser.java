package manage;

import account.User;

import java.util.ArrayList;
import java.util.List;

public class ManageUser {
    List<User> userList = new ArrayList<>();
    public static User currentUser = null;
    int count = 0;


    public List<User> getUserList(){
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void add(User user) {
        userList.add(user);
    }

    public void display() {
        boolean check = false;
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
            check = true;
        }
        if (check == false) {
            System.out.println("Chua co tai khoan!");
        }
    }

    public int login(String username, String password) {
//        if (count == 0) {
//            System.out.println("Ban chua co tai khoan , moi dang ky tai khoan!");
//        } else {
//            for (int i = 0; i < userList.size(); i++) {
//                if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassWord().equals(password)) {
//                    System.out.println("Dang nhap thanh cong");
//                }
//                if (userList.get(i).getUserName().equals(username) || userList.get(i).getPassWord().equals(password)) {
//                    System.out.println("Khong dung tai khoan dang nhap");
//                }
//            }
//        }
        for (User user : userList){
            if (user.getUserName().equals(username) && user.getPassWord().equals(password)){
                currentUser = user;
                return 1;
            }
        } return 0;
    }

    public void editUserName(String username, String password, User user) {
        if (count == 0) {
            System.out.println("Ban chua dang ky tai khoan , moi dang ky tai khoan");
        } else {
            int indexOfUserName = findByUserName(username, password);
            if (indexOfUserName == -1) {
                System.out.println("Nhap sai tai khoan , vui long nhap lai!");
            } else {
                userList.set(findByUserName(username, password), user);
                System.out.println("Thay mat khau thanh cong!");
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
    public int findIndexById(int id){
        for (int i  = 0 ; i < userList.size(); i++){
            System.out.println(userList.get(i));
            return i;
        }
        return -1;
    }

    public void edit(int id , User user){
        userList.set(findIndexById(id),user);
    }

    public void delete(int id){
        userList.remove(findIndexById(id));
    }

}
