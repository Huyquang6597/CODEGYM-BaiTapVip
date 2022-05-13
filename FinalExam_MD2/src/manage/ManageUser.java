package manage;

import file.WriteAndReadFile;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class ManageUser {
    WriteAndReadFile writeAndReadFile = new WriteAndReadFile();
    private List<User> userList = new ArrayList<>();
//    User user = new User();

    public ManageUser(){
        userList= writeAndReadFile.readFileUser("/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/FinalExam_MD2/src/file/User.csv", userList);
    }


    public List<User> getUserList() {
        return userList;
    }

    public void add(User user1) {
        userList.add(user1);
    }

    public void display() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
        System.out.println("-----------------------------------");
    }

    public int findIndexByPhoneNumber(int phoneNumber) { // Cái này trả về vị trí (chỉ vị trí ko hiển thị thông tin) phục vụ cho việc sửa danh bạ theo số đt
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getPhoneNumber() == phoneNumber) {
                return i;
            }
        }
        return -1;
    }


    public int findByName(String name){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


   public void finđInexByName1(String name){//tìm kiếm chung
       boolean check = false;
       for (int i = 0; i < userList.size(); i++) {
           if(userList.get(i).getName().contains(name)){
               System.out.println(userList.get(i));
               check = true;
           }
       }
       if (check == false) {
           System.out.println("There is no phone number like above !");
       }
   }


    public void delete(int phoneNumber) {
        if (findIndexByPhoneNumber(phoneNumber) != -1) {
            userList.remove(findIndexByPhoneNumber(phoneNumber));
            System.out.println("Delete directory successfully! ");
        } else {
            System.out.println("No phone number found !");
        }
    }

    public void edit(int phoneNumber, User user1) {
        int indexOfPhoneNumber = findIndexByPhoneNumber(phoneNumber);
        if (indexOfPhoneNumber == -1) {
            System.out.println("No phone number found !");
        }
    }

}
