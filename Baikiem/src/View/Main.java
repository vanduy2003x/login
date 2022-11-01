package View;

import Model.User;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        //Create default value
        User userDefault = new User("dat","dat@gmail.com","123");
        ArrayList<User> users = new ArrayList<>(asList(userDefault));
        Scanner scanner = new Scanner(System.in);

       /*
       // Test regex
        String email = "dat@gmail2.com";
        String password = "Chudat18!";
        //System.out.println(Pattern.matches(Constant.REGEX_EMAIL, email));
        System.out.println(Pattern.matches(Constant.REGEX_PASSWORD, password));
        */
        HomeView homeView = new HomeView();
        homeView.displayHomeView(scanner, users);

    }
}
