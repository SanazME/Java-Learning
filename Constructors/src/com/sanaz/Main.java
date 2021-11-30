package com.sanaz;

public class Main {

    public static void main(String[] args) {
	    BankAccount bank1 = new BankAccount(
//                "12312",
//                0.0,
//                "Bob",
//                "bob@email.com",
//                "23234234234"
        );
        bank1.deposit(2342.434);

        System.out.println(bank1.getBalance());

        bank1.withdraw(2342.432);
        System.out.println(bank1.getBalance());

        bank1.deposit(5);
        bank1.withdraw(10);
        System.out.println(bank1.getBalance());

        BankAccount timAccount = new BankAccount("Tim","timEmail@", "somePhone123234");

        /*
        * // Create a new class VipCustomer
        // it should have 3 fields name, credit limit, and email address.
        // create 3 constructors
        // 1st constructor empty should call the constructor with 3 parameters with default values
        // 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
        // 3rd constructor should save all fields.
        // create getters only for this using code generation of intellij as setters wont be needed
        // test and confirm it works.
        * */
        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer("Alice", "alice@email");
        System.out.println(person2.getName());
    }
}
