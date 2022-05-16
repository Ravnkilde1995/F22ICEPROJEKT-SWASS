package system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static system.DBConnection.connection;

public class TransactionMenu {

    static TransactionRepo transactionRepo;

    public static void TransactionMenu(Scanner input, ArrayList<Transaction> transactions, ArrayList<User> users) {

        int answer = 1;

        while (answer != 0) {
            System.out.println("Transaction menu");
            System.out.println("Select your options");
            System.out.println("-------------------------\n");
            System.out.println("Press '1' to search for a user...");
            System.out.println("Press '2' to make a transaction");
            System.out.println("Press '0' to return to main menu");

            answer = input.nextInt();
            switch (answer) {
                case 1:
                    searchForUser(input);
                    break;
                case 2:
                    commitTransactions(input);
                    break;
                case 0:
                    System.out.println("returning to main menu... \n");
                    break;
            }
        }
    }


    // Methods
    //***

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

                System.out.println(firstname + " " + lastname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commitTransactions(Scanner input){
        System.out.println("Type in your username: ");
        String username = input.next();
        System.out.println("Type in the ID of the user you want to transfer money to");
        int ID = input.nextInt();
        System.out.println("Type in the amount of money you want to transfer: ");
        int amount = input.nextInt();
        System.out.println("Type in the date of the transaction: ");
        int date = input.nextInt();

        UserRepo userRepo = new UserRepo();
        User sender = UserRepo.getUserByUsername(username);
        User reciever = UserRepo.getUserByID(ID);

        int recieverAmount = reciever.balance+amount;
        int senderAmount = sender.balance-amount;

        if(sender.getBalance()>=0) {
            userRepo.update(username, senderAmount);
            userRepo.update(reciever.getUsername(), recieverAmount);

            TransactionRepo transactionRepo = new TransactionRepo();
            Transaction transactions = new Transaction(date, amount, username, ID);
            transactionRepo.create(transactions);
        }
        else {
            System.out.println("You dont have enought money to transfer");
        }
    }
}