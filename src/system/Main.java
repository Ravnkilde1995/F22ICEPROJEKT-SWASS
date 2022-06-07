package system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList <Transaction> transactions = new ArrayList<>();

        DBConnection.createConnection();

        TransactionMenu.transactionRepo = new TransactionRepo();
        UserMenu.userRepo = new UserRepo();

        transactions = TransactionMenu.loadData();

        LoginMenu.loginMenu(input, transactions);

    }
}
