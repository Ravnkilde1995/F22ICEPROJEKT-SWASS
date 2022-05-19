package system;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static system.Transaction.transactionID;


public class UserMenu {

    static UserRepo userRepo;

    public static void userMenu(Scanner input) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("User menu \n");
            System.out.println("Select your options");
            System.out.println("------------------------- \n");
            System.out.println("Press '1' to show balance");
            System.out.println("Press '2' to withdraw money");
            System.out.println("Press '3' to add money to an account");
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


    public static void saveData(ArrayList<Transaction> transactions) {

        String data = "";

        for(Transaction t: transactions) {

            data+=   t.getDate1() + "," +  t.getAmount() + "," +  t.getSender() +"," + t.getReciever() + ",";

        }

        try {
            FileWriter output = new FileWriter("src/system/TransactionData.txt");
            output.write(data);
            output.close();
        }
        catch (IOException exception) {

        }
    }

    public static ArrayList<Transaction> loadData(){

        File text = new File("src/system/TransactionData.txt");
        ArrayList<Transaction> transactions = new ArrayList<>();

        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.length()>0){
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.useDelimiter(",");

                    String date = lineScanner.next();

                    int amount = lineScanner.nextInt();

                    String sender = lineScanner.next();

                    int reviever = lineScanner.nextInt();

                    Transaction loadedTransactions = new Transaction(date, amount, sender, reviever);
                    transactions.add(loadedTransactions);
                    System.out.println(transactions);

                }
            }

        }catch (IOException exception) {

        }

        return transactions;

    }
}
