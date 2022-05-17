package system;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    static ArrayList <UserMenu> userMenu;
    //static ArrayList <LoginMenu> loginMenu;
    static ArrayList <TransactionMenu> transactionMenu;
    static UserRepo userRepo;
    static TransactionRepo transactionRepo;


    public static void MainMenu(Scanner input) {
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
                    TransactionMenu.TransactionMenu(input);
                    break;
                case 0:
                    System.out.println("Going back to login menu... \n");
                    break;
            }
        }
    }
}

