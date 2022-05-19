package system;

import java.util.Date;

public class Transaction {

    //Fields
    //***********************

    static int transactionID;
    int amount;
    String sender;
    int reciever;
    Date currentDate = new Date();
    String date1 = String.valueOf(currentDate);

    // Constructor
    //***********************

    public Transaction(String date1, int amount, String sender, int reciever) {
        this.transactionID = transactionID;
        this.date1 = date1;
        this.amount = amount;
        this.sender = sender;
        this.reciever = reciever;

    }

    public Transaction(int transactionID, String date1, int amount, String sender, int reciever) {
        this.transactionID = transactionID;
        this.date1 = date1;
        this.amount = amount;
        this.sender = sender;
        this.reciever = reciever;

    }

    // Methods
    //***********************

    public String getDate1() {
        return date1;
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
                "transactionID: " + transactionID +
                ", date: " + date1 +
                ", amount: " + amount + " DKK" +
                ", sender: " + sender +
        ", reciever: " + reciever  +
        '\n';
    }
}
