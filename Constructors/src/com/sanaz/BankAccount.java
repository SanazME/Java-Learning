package com.sanaz;
/*
* 	    // Create a new class for a bank account
        // Create fields for the account number, balance, customer name, email and phone number.
        //
        // Create getters and setters for each field
        // Create two additional methods
        // 1. To allow the customer to deposit funds (this should increment the balance field).
        // 2. To allow the customer to withdraw funds. This should deduct from the balance field,
        // but not allow the withdrawal to complete if their are insufficient funds.
        // You will want to create various code in the Main class (the one created by IntelliJ) to
        // confirm your code is working.
        // Add some System.out.println's in the two methods above as well.
* */
public class BankAccount {
    private String account;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this("123234", 0.0, "SomeUser", "someEmail", "1233435");
        System.out.println("An Empty Constructor!");
    }

    public BankAccount(String account, double balance, String customerName, String email, String phoneNumber) {
        System.out.println("Account constructor with params is called!");
        this.account = account;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit of " + amount + " is processed. The balance is: " + this.balance);
        } else {
            System.out.println("Invalid input amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                this.balance -= amount;
                System.out.println("Withdrawal amount of " + amount + " is processed. The balance is: " + this.balance);
            } else {
                System.out.println("Withdrawal is larger than the balance. Only " + this.balance + " is available.");
            }
        } else {
            System.out.println("Invalid input amount");
        }
    }
}
