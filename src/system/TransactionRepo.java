package system;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static system.DBConnection.connection;

public class TransactionRepo implements Repo<Transaction> {

    @Override
    public void update(String username, int balance) {

    }

    @Override
    public void create(Transaction transactions) {

        try{
            String sql = "INSERT INTO transactions(date, amount, sender, reciever) VALUES(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transactions.getDate1());
            preparedStatement.setInt(2, transactions.getAmount());
            preparedStatement.setString(3, transactions.getSender());
            preparedStatement.setInt(4, transactions.getReciever());

            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    static Transaction getTransactionsByUserName (String userName){

        try{
            String sql = "SELECT * FROM transaction WHERE reciever = " + userName + "OR sender = " + userName;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int ID = resultSet.getInt("transactionID");
                String date1 = resultSet.getString("date");
                int amount = resultSet.getInt("amount");
                String sender = resultSet.getString("sender");
                int reciever = resultSet.getInt("reciever");

                Transaction transaction = new Transaction(ID, date1, amount, sender, reciever);
                return transaction;
            }

        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    } */
}
