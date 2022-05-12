package system;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionMenu {

    //static TransactionRepo;

    public static void TransactionMenu(Scanner input, ArrayList<Transaction> transactions) {

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
                    searchForUser();
                    break;
                case 2:
                    commitTransactions();
                    break;
                case 0:
                    System.out.println("returning to main menu...");
                    break;
            }
        }
    }


    // Methods
    //***

    void searchForUser(Scanner input, ArrayList<User> user){

    }

    void commitTransactions(Scanner input, ArrayList<User> user){

    }
}