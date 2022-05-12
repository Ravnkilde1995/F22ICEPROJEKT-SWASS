package system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList <Transaction> transactions = new ArrayList<>();
        ArrayList <User> users = new ArrayList<>();

        DBConnection.createConnection();

        TransactionMenu.transactionRepo = new TransactionRepo();
        //transaction = TransactionMenu.transactionRepo.readAll();

        UserMenu.userRepo = new UserRepo();
        //user = UserMenu.userRepo.readAll();

        MainMenu.MainMenu(input, transactions, users);
        UserMenu.UserMenu(input, users, transactions);
        TransactionMenu.TransactionMenu(input, transactions, users);
    }
}
