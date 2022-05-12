package system;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionMenu {

    static TransactionRepo transactionRepo;

    public static void TransactionMenu(Scanner input, ArrayList<Transaction> transactions, ArrayList<User> users) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Transaction menu");
            System.out.println("**");
            System.out.println("Press 1 to search for a user...");
            System.out.println("Press 2 to make a transaction");
            System.out.println("Press 0 to return to main menu");

            answer = input.nextInt();
            switch (answer) {
                case 1:
                    searchForUser(input, users);
                    break;
                case 2:
                    commitTransactions(input, users);
                    break;
                case 0:
                    System.out.println("returning to main menu...");
                    break;
            }
        }
    }


    // Methods
    //***

    public static void searchForUser(Scanner input, ArrayList<User> users){

    }

    public static void commitTransactions(Scanner input, ArrayList<User> users){

    }
}