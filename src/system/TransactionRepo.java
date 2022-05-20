package system;
import java.sql.PreparedStatement;

import static system.DBConnection.connection;

public class TransactionRepo implements Repo<Transaction> {


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
}
