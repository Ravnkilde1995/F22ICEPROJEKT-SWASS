package system;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {


    public static void MainMenu(Scanner input, ArrayList<Transaction> transactions) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Main menu \n");
            System.out.println("Select your options");
            System.out.println("------------------------- \n");
            System.out.println("Press '1' to show user menu");
            System.out.println("Press '2' to show transaction menu");
            System.out.println("Press '0' to return to login menu");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    UserMenu.UserMenu(input);
                    break;
                case 2:
                    TransactionMenu.TransactionMenu(input, transactions);
                    break;
                case 0:
                    System.out.println("Going back to login menu... \n");
                    break;
            }
        }
    }
}

