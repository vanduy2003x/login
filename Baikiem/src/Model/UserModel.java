package Model;

import View.HomeView;
import utiles.Constant;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserModel {

    public User register(Scanner sc, ArrayxList<User> users){
        boolean flag= true;

        String username = "null", pass = "", email="";
        while (flag){
            System.out.println("Mời b nhập username: ");
            username= sc.nextLine();
            System.out.println("Mời b nhập password");
            pass= sc.nextLine();
            System.out.println("Mời b nhập email: ");
            email = sc.nextLine();
            // kiểm tra password và email có hợp lệ hay k
            if(checkValidPasswordAndEmail(email, pass)){
                // kiểm tra xem username và email đã tồn tại hay chưa
                if(!checkExistedUsername(username, users) && !checkExistedEmail(email, users)){
                    flag = false;
                }
            }
        }

        User user = new User(username,email, pass);
        return user;
    }

    public String login(Scanner sc, ArrayList<User> users){
        sc.nextLine();
        System.out.println("Mời b nhập username: ");
        String username= sc.nextLine();
        System.out.println("Mời b nhập password:");
        String pass= sc.nextLine();
        for(User user: users){
            // Kiểm tra xem username và pass có đúng k
            if(user.getUsername().equals(username) && user.getPassword().equals(pass)){
                System.out.println("bai.Test.Login successfully!");
                //Hiển thị màn hình chức năng
                HomeView homeView = new HomeView();
                homeView.actionView(sc, user, users);
                // Trả về tên người dùng
                return username;
            }
        }
        System.out.println("bai.Test.Login fail");
        return "";
    }

    public void forgetPassword(Scanner sc, ArrayList<User> users){
        System.out.println("input email: ");
        String email = sc.nextLine();
        for(User user: users){
            if(user.getEmail().equals(email)){
                System.out.println("Password is sent to "+ email);
                System.out.println("Please input new pass: ");
                user.setPassword(sc.nextLine());
                System.out.println("Change password successfully");
            }

        }
    }

    public boolean checkExistedUsername(String username, ArrayList<User> users){
        for (User u: users){
            // Nếu tồn tại -> yêu cầu nhập lại
            if(u.getUsername().equals(username)){
                System.out.println("Username  này đã tồn tại vui lòng nhập lại");
                return true;
            }
        }
        return false;
    }

    public boolean checkExistedEmail(String email, ArrayList<User> users){
        // duyệt tất cả trong list xem email đã tồn tại hay chưa
        for (User u: users){
            // Nếu tồn tại -> yêu cầu nhập lại
            if(u.getEmail().equals(email)){
                System.out.println("email  này đã tồn tại vui lòng nhập lại");
                return true;
            }
        }
        return false;
    }

    public boolean checkValidPasswordAndEmail(String email, String password){
        if(!Pattern.matches(Constant.REGEX_EMAIL,email)){
            System.out.println("Email không hợp lệ, vui lòng thử lại");
            return false;
        }
        if(!Pattern.matches(Constant.REGEX_PASSWORD,password)){
            System.out.println("Password không hợp lệ, vui lòng thử lại");
            return false;
        }
        return true;
    }
}
