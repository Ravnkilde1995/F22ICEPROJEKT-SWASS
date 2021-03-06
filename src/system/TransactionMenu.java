package system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static system.DBConnection.connection;
import static system.LoginMenu.currentUser;

public class TransactionMenu {

    static TransactionRepo transactionRepo;

    public static void transactionMenu(Scanner input, ArrayList<Transaction> transactions) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Transaction menu");
            System.out.println("Select your options");
            System.out.println("-------------------------\n");
            System.out.println("Press '1' to search for a user...");
            System.out.println("Press '2' to make a transaction");
            System.out.println("Press '3' to show recent transactions");
            System.out.println("Press '0' to return to main menu");

            answer = input.nextInt();

            switch (answer) {
                case 1:
                    searchForUser(input);
                    break;

                case 2:
                    commitTransactions(input, transactions);
                    saveData(transactions);
                    break;

                case 3:
                    showTransactions(input, transactions);
                    break;

                case 0:
                    System.out.println("returning to main menu... \n");
                    break;
            }
        }
    }

    // Methods
    //***********************

    public static void searchForUser (Scanner input){

        System.out.println("Search for a user");
        String searchForAUser = input.next();

        String sql = "SELECT * FROM users WHERE name LIKE " + "'%" + searchForAUser + "%'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String firstname = rs.getString("name");
                String lastname = rs.getString("lastname");

                String user = firstname + " " + lastname;
                System.out.println(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void commitTransactions(Scanner input, ArrayList<Transaction> transactions){

        System.out.println("Type in the ID of the user you want to transfer money to");
        int ID = input.nextInt();

        System.out.println("Type in the amount of money you want to transfer: ");
        int amount = input.nextInt();

        Date date = new Date();
        String currentDate = String.valueOf(date);

        UserRepo userRepo = new UserRepo();
        User sender = UserRepo.getUserByUsername(currentUser);
        User reciever = UserRepo.getUserByID(ID);

        int recieverAmount = reciever.getBalance()+amount;
        int senderAmount = sender.getBalance()-amount;


        if(sender.getBalance()-amount>=0) {
            userRepo.update(currentUser, senderAmount);
            userRepo.update(reciever.getUsername(), recieverAmount);

            TransactionRepo transactionRepo = new TransactionRepo();
            Transaction allTransactions = new Transaction(currentDate, amount, currentUser, ID);

            transactionRepo.create(allTransactions);
            transactions.add(allTransactions);

        }
        else {
            System.out.println("You dont have enought money to transfer");
        }
    }

    public static void showTransactions(Scanner input, ArrayList<Transaction> transactions) {

        System.out.println("type in your username: ");
        String username = input.next();

        for (Transaction t: transactions) {

            if(username.equals(t.getSender())){
                System.out.println(t);

            }
        }
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

                if (line.length() > 0) {
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.useDelimiter(",");
                    String date = lineScanner.next();
                    int amount = lineScanner.nextInt();
                    String sender = lineScanner.next();
                    int reviever = lineScanner.nextInt();

                    Transaction loadedTransactions = new Transaction(date, amount, sender, reviever);
                    transactions.add(loadedTransactions);

                }
            }

        }catch (IOException exception) {

        }

        return transactions;

    }
}