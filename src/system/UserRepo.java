package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserRepo implements Repo<User>{

    static Connection connection = DBConnection.connection;

    @Override
    public ArrayList<User> readAll() {
        return null;
    }

    @Override
    public void create(User user) {

        try{
            String sql = "INSERT INTO users(name, lastname, socialsecuritynumber, gender, username, password, phonenumber) VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getSocialSecurityNumber());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getUsername());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setInt(7, user.getPhoneNumber());

            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
     public void update(String username, int balance) {

            String sql = "UPDATE users SET balance = " + balance + " WHERE username = + " + "'" + username + "'";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void delete(int id) {

    }

    static User getUserByUsername(String username) {

        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                int id = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                int socialsecuritynumber = resultSet.getInt("socialsecuritynumber");
                String gender = resultSet.getString("gender");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                int phoneNumber = resultSet.getInt("phonenumber");
                int balance = resultSet.getInt("balance");

                User user = new User(id, name, lastName, socialsecuritynumber, gender, userName, password, phoneNumber, balance);
                return user;
        }

    }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;

    }

    static User getUserByID(int ID) {

        try {
            String sql = "SELECT * FROM users WHERE userid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                int id = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                int socialsecuritynumber = resultSet.getInt("socialsecuritynumber");
                String gender = resultSet.getString("gender");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                int phoneNumber = resultSet.getInt("phonenumber");
                int balance = resultSet.getInt("balance");

                User reciever = new User(id, name, lastName, socialsecuritynumber, gender, userName, password, phoneNumber, balance);
                return reciever;
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;

    }
}
