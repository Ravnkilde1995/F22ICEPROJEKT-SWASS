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
            System.out.println("**");
            System.out.println("Press 1 to search for a user...");
            System.out.println("Press 2 to make a transaction");
            System.out.println("Press 0 to return to main menu");

            answer = input.nextInt();
            switch (answer) {
                case 1:
                    searchForUser(input);
                    break;
                case 2:
                    commitTransactions(input);
                    break;
                case 0:
                    System.out.println("returning to main menu...");
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

    }
}