package system;

public class User {

    //Fields
    //***********************

    private int userID;
    private String name;
    private String lastName;
    private int socialSecurityNumber;
    private String gender;
    private String username;
    private String password;
    private int phoneNumber;
    private int balance;

    //Constructor
    //***********************

    public User(int userID, String name, String lastName, int socialSecurityNumber, String gender, String username, String password, int phoneNumber, int balance) {
        this.userID = userID;
        this.name = name;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = balance;

    }

    public User(String name, String lastName, int socialSecurityNumber, String gender, String username, String password, int phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    //Methods
    //***********************

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getBalance() {
        return balance;
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", balance=" + balance +
                '}';

    }
}
