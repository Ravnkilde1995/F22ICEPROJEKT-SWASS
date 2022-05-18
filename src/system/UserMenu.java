package system;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static system.Transaction.transactionID;


public class UserMenu {

    static UserRepo userRepo;
    static User user;

    public static void UserMenu(Scanner input, ArrayList<Transaction> transactions) {
        int answer = 1;

        while (answer != 0) {
            System.out.println("User menu \n");
            System.out.println("Select your options");
            System.out.println("------------------------- \n");
            System.out.println("Press '1' to show balance");
            System.out.println("Press '2' to withdraw money");
            System.out.println("Press '3' to add money to an account");
            System.out.println("Press '4' to show recent transactions");
            System.out.println("Press '0' to return to main menu");


            answer = input.nextInt();

            switch (answer) {
                case 1:
                    showBalance(input);
                    break;
                case 2:
                    withdrawMoney(input);
                    break;
                case 3:
                    addDeposit(input);
                    break;
                case 4:
                    showTransactions(input, transactions);
                    break;
                case 0:
                    System.out.println("Returning to the main menu \n");
                    break;
            }
        }
    }

    public static void showBalance(Scanner input) {
        System.out.println("Type in your username: ");
        String username = input.next();

        UserRepo userRepo = new UserRepo();
        User user = UserRepo.getUserByUsername(username);

        System.out.println("Total balance: " + "\n" + user.getBalance() + " DKK" + "\n");
    }

    public static void withdrawMoney(Scanner input) {
        System.out.println("Type in your username: ");
        String username = input.next();
        System.out.println("Type in how much money you want to withdraw: ");
        int amount = input.nextInt();

        UserRepo userRepo = new UserRepo();
        User user1 = UserRepo.getUserByUsername(username);

        int balance=user1.balance-amount;

        if(balance>=0) {
            userRepo.update(username, balance);
            System.out.println("Withdrawing money from the account..." + "\n");
        }
        else {
            System.out.println("You cant withdraw money from the account" + "\n");
        }
    }

    public static void addDeposit(Scanner input) {
        System.out.println("Type in your username: ");
        String username = input.next();
        System.out.println("Type in how much money you want to deposit: ");
        int amount = input.nextInt();

        UserRepo userRepo = new UserRepo();
        User user1 = UserRepo.getUserByUsername(username);

        int balance=user1.balance+amount;

        userRepo.update(username, balance);

        System.out.println("Depositing money to the account..." + "\n");
    }

    public static void showTransactions(Scanner input, ArrayList<Transaction> transactions) {

        System.out.println("type in your username: ");
        String username = input.next();

        for (Transaction t: transactions) {

            for(int i=0; i < transactions.size();i++){
                transactionID = transactionID+=i;
            }

            if(username.equals(t.getSender())){
                System.out.println(t);
            }
        }
    }

    public static void saveData(ArrayList<Transaction> transactions) {
        String data = "";
        for(Transaction t: transactions) {
            data+= "TransactionID: " + transactionID + "Date: " + t.getDate1() +
                    "Amount: " + t.getAmount() + "Sender: " + t.getSender() +
                    "Reciever: " + t.getReciever();
        }

        try {
            FileWriter output = new FileWriter("src/system/TransactionData.txt");
            output.write(data);
            output.close();
        }
        catch (IOException exception) {

        }
    }
}
