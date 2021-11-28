package com.sanaz;

public class Main {

    public static void main(String[] args) {
	    BankAccount bank1 = new BankAccount();
        bank1.deposit(2342.434);

        System.out.println(bank1.getBalance());

        bank1.withdraw(2342.432);
        System.out.println(bank1.getBalance());

        bank1.deposit(5);
        bank1.withdraw(10);
        System.out.println(bank1.getBalance());
    }
}
