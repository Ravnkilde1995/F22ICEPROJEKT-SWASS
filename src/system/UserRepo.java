package system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public void update(User user, int id) {

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
                String password = resultSet.getString("password");

                User user = new User(id, username, password);
                return user;

        }

    }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;

    }
}
