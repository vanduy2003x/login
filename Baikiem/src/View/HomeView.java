package View;

import Model.User;
import Model.UserModel;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeView {
    UserModel userModel = new UserModel();


    public void displayHomeView(Scanner scanner, ArrayList<User> users){
        System.out.println("------------Menu------------");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("Please choose: ");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                String checkLogin =userModel.login(scanner, users);
                // if checkLogin == "" -> login fail
                if(checkLogin.equals(""))
                    loginWrongView(scanner,users);

                break;
            case 2:
                User user = userModel.register(scanner, users);
                users.add(user);
        }
    }

    public void loginWrongView(Scanner scanner, ArrayList<User> users){
        System.out.println("Username or password is wrong! ");
        System.out.println("1: Login again");
        System.out.println("2: Forget password");
        System.out.println("Please choose:");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                userModel.login(scanner, users);
                break;
            case 2:
                userModel.forgetPassword(scanner, users);
                break;
        }
    }

    public void actionView(Scanner sc, User user, ArrayList<User> users){
        System.out.println("Chào mừng <"+user.getUsername()+">, bạn có thể thực hiện các công việc sau:");
        System.out.println("1 - Thay đổi username\n" +
                "\n" +
                "2 - Thay đổi email\n" +
                "\n" +
                "3 - Thay đổi mật khẩu\n" +
                "\n" +
                "4 - Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký)\n" +
                "\n" +
                "0 - Thoát chương trình\n" +
                "\n" +
                "Lưu ý: username và email mới phải chưa tồn tại");
        System.out.println("Mời b chọn: ");
        int choose= sc.nextInt();
        switch (choose){
            case 1:
                boolean flag = true;
                while (flag){
                    System.out.println("Mời b nhập username mới: ");
                    String username = sc.nextLine();
                    if(!userModel.checkExistedUsername(username, users)){
                        flag=false;
                        user.setUsername(username);
                        System.out.println("Đổi username thành công");
                    }
                }
                break;
            case 2:
                boolean flag2 = true;
                while (flag2){
                    System.out.println("Mời b nhập email mới: ");
                    String email = sc.nextLine();
                    if(!userModel.checkExistedEmail(email, users)){
                        flag2=false;
                        user.setEmail(email);
                        System.out.println("Đổi email thành công");
                    }
                }
                break;
            case 3:
                System.out.println("Mời b nhập password mới: ");
                String password = sc.nextLine();
                user.setPassword(password);
                System.out.println("Đổi mk thành công");
                break;
            case 4:
                displayHomeView(sc, users);
                break;
            case 5:
                System.exit(0);

        }
    }
}
