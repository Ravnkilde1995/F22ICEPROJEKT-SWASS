package system;

import java.util.Date;

public class Transaction {
    //Fields
    //***********************

    int transactionID;
    int date;
    int amount;
    String sender;
    int reciever;
    Date currentDate = new Date();
    String date1 = String.valueOf(currentDate);

    // Constructor
    //***********************

    public Transaction(Date currentDate, int amount, String sender, int reciever) {
        this.transactionID = transactionID;
        this.date = date;
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
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", date=" + date +
                ", amount=" + amount +
                ", sender='" + sender +
        ", reciever='" + reciever  +
        '}';
    }
}
