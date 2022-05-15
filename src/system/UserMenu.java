package system;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {

    static UserRepo userRepo;

    public static void UserMenu(Scanner input, ArrayList<User> users, ArrayList<Transaction> transactions) {
        int answer = 1;

        while (answer != 0) {
            System.out.println("User menu");
            System.out.println("Press 1 to show balance");
            System.out.println("Press 2 to withdraw money");
            System.out.println("Press 3 to add money to an account");
            System.out.println("Press 4 to show recent transactions");
            System.out.println("Press 0 to return to main menu");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    showBalance(users);
                    break;
                case 2:
                    withdrawMoney(input, users);
                    break;
                case 3:
                    addMoney(input, users);
                    break;
                case 4:
                    showTransactions(users, transactions);
                    break;
                case 0:
                    System.out.println("Returning to the main menu");
                    break;
            }
        }
    }

    public static void showBalance(ArrayList<User> users) {

    }

    public static void withdrawMoney(Scanner input, ArrayList<User> users) {

    }

    public static void addMoney(Scanner input, ArrayList<User> users) {

    }

    public static void showTransactions(ArrayList<User> users, ArrayList<Transaction> transactions) {

    }
}
