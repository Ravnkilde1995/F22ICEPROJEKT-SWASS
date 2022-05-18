package system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList <Transaction> transactions = new ArrayList<>();

        DBConnection.createConnection();

        TransactionMenu.transactionRepo = new TransactionRepo();
        UserMenu.userRepo = new UserRepo();

        LoginMenu.LoginMenu(input, transactions);
        MainMenu.MainMenu(input, transactions);

        UserMenu.saveData(transactions);
    }
}
