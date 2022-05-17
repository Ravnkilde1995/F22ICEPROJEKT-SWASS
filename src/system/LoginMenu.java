package system;

import java.util.ArrayList;
import java.util.Scanner;


public class LoginMenu {

    static String username;
    static int answer;

    public static void LoginMenu(Scanner input) {


        answer = 1;

        while (answer != 0) {

            // Reference https://localcoder.org/java-print-in-bold

            System.out.print("\033[0;1m" + "Login menu" + "\n" + "\n");
            System.out.println("Select your options");
            System.out.println("-------------------------\n");
            System.out.println("Press '1' to login ");
            System.out.println("Press '2' to create a new user ");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    login(input);
                    break;
                case 2:
                    create(input);
                    break;
            }
        }
    }

    static void login(Scanner input) {

        boolean loggedIn = false;

        while(!loggedIn) {
            System.out.println("LOG IN");

            System.out.print("Username: ");
            String usernameInput = input.next();

            System.out.print("Password: ");
            String passwordInput = input.next();
            System.out.println("\n");

            User user = UserRepo.getUserByUsername(usernameInput);

            loggedIn = validateLogin(input, user, passwordInput);
        }

        System.out.println("you are logged in as " + username + "\n");
        System.out.println("Redirecting to main menu..."+ "\n");

    }

    static boolean validateLogin(Scanner input, User user, String passwordInput){
        if(user != null){
            if(user.password.equals(passwordInput)){
                username = user.username;
                answer = 0;
                myPageMenu(input, user);
                return true;
            }else{
                System.out.println("\n"+"Wrong user name or password");
            }
        }else{
            System.out.println("\n"+"Wrong user name or password");
        }
        System.out.println();
        return false;
    }

    public static void create(Scanner input) {

        System.out.println("Creating new user: "+"\n");

        System.out.println("insert first name: ");
        String firstname = input.next();
        System.out.println("insert last name: ");
        String lastname = input.next();
        System.out.println("insert social security number: ");
        int socialSecurityNumber = input.nextInt();
        System.out.println("insert your gender: ");
        String gender = input.next();
        System.out.println("insert username: ");
        String userName = input.next();
        System.out.println("insert password: ");
        String password = input.next();
        System.out.println("insert your phone number: ");
        int phoneNumber = input.nextInt();

        User user = new User(firstname, lastname, socialSecurityNumber, gender, userName, password, phoneNumber);
        System.out.println("\n You have succesfully created a user. Continue to login \n");
        UserRepo userRepo = new UserRepo();
        userRepo.create(user);
    }


    public static void myPageMenu(Scanner input, User user) {
        int answer = 1;

        while (answer != 0) {
            System.out.println("Press 1 to show personal page");
            System.out.println("Press 2 to go to main menu");
            System.out.println("Press 0 to logout");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("\n" + "Hello, " + user.getName() + " " + user.getLastName() + "\n" +
                            "\n" + "Your personal information" + "\n" + "------------------------- \n" +
                            "\n" + "SSN: " + user.getSocialSecurityNumber() +
                            "\n" + "Gender: " + user.getGender() +
                            "\n" + "Phonenumber: " + user.getPhoneNumber() +
                            "\n" + "Balance: " + user.getBalance() + " DKK" +
                            "\n");
                    break;
                case 2:
                    System.out.println("Redirecting to main menu..." + "\n");
                    MainMenu.MainMenu(input);
                    break;
                case 0:
                    System.out.println("Logging out \n");
                    LoginMenu(input);
                    break;
            }
        }
    }
}
