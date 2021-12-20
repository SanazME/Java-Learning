package com.sanaz;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("8236782348726");

    public static void main(String[] args) {
        boolean quit = false;
        printActions();

        while (!quit){
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }

    }

    private static void queryContact(){
        System.out.println("Enter a name to be queried");
        String name = scanner.nextLine();

        Contact existingContact = mobilePhone.queryContact(name);

        if (existingContact != null){
            System.out.println("Contact was found with name: " + existingContact.getName() + " and phone number: " + existingContact.getPhoneNumber());
        } else {
            System.out.println("Contact was not found");
        }
    }

    private static void removeContact(){
        System.out.println("Enter existing contact name");
        String oldName = scanner.nextLine();

        Contact existingContact = mobilePhone.queryContact(oldName);

        if (existingContact != null ){
            if (mobilePhone.removeContact(existingContact)){
                System.out.println("Contact was removed");
            } else {
                System.out.println("Contact was NOT removed");
            }
        } else {
            System.out.println("Existing contact not FOUND!");
            return;
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name");
        String oldName = scanner.nextLine();


        Contact existingContact = mobilePhone.queryContact(oldName);

        if (existingContact != null ){
            System.out.println("Enter new contact name");
            String newName = scanner.nextLine();
            System.out.println("Enter new phone number");
            String newPhoneNumber = scanner.nextLine();

            Contact newContact = Contact.newInstance(newName, newPhoneNumber);

            if (mobilePhone.updateContact(existingContact, newContact)){
                System.out.println("Contact was updated");
            } else {
                System.out.println("Contact was NOT updated");
            }
        } else {
            System.out.println("Existing contact not FOUND!");
            return;
        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String phoneNumber = scanner.nextLine();

        Contact newContact = Contact.newInstance(name, phoneNumber);

        if (mobilePhone.addNewContact(newContact)){
            System.out.println("New contact name: " + name + " phone: " + phoneNumber + " is added!");
        } else {
            System.out.println("Cannot add " + name + " already on file.");
        }
    }


    private static void startPhone(){
        System.out.println("Starting phone ...");
    }

    private static void printActions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To to shut down.");
        System.out.println("\t 1 - To print contacts.");
        System.out.println("\t 2 - To add a new contact");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove an existing contact.");
        System.out.println("\t 5 - to query if a contact exits.");
        System.out.println("\t 6 - to print a list of actions.");
    }
}
