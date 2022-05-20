package system;

import java.util.Date;

public class Transaction {

    //Fields
    //***********************

    static int transactionID;
    private int amount;
    private String sender;
    private int reciever;
    Date currentDate = new Date();
    private String date = String.valueOf(currentDate);

    // Constructor
    //***********************

    public Transaction(String date, int amount, String sender, int reciever) {
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.sender = sender;
        this.reciever = reciever;

    }

    // Methods
    //***********************

    public String getDate1() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getSender() {
        return sender;
    }

    public int getReciever() {
        return reciever;
    }


    @Override
    public String toString() {
        return "Transaction: " +
                "date: " + date +
                ", amount: " + amount + " DKK" +
                ", sender: " + sender +
        ", reciever: " + reciever  +
        '\n';

    }
}
