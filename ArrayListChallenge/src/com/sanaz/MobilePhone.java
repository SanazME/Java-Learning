package com.sanaz;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> myContacts;
    private String myNumber;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    private int findContact(Contact contact) {
        int idx = myContacts.indexOf(contact);
        return idx;
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        int idx = findContact(name);

        if (idx >= 0){
            return myContacts.get(idx);
        } else {
            return null;
        }
    }

    public String queryContact(Contact contact){
        if (findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public boolean addNewContact(Contact contact){
        // A new contact
        if (findContact(contact) < 0 ){
            myContacts.add(contact);
            return true;
        } else {
            System.out.println("The contact existed!");
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if (findContact(oldContact) >= 0){
            // check if the new contact exits in the phonebook
            System.out.println(findContact(newContact) );
            if (findContact(newContact.getName()) >= 0){
                System.out.println("New contact is already existed");
                return false;
            } else {
                int idx = findContact(oldContact);
                myContacts.set(idx, newContact);
                return true;
            }

        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact) >= 0 ){
            int idx = findContact(contact);
            myContacts.remove(idx);
            return true;
        } else {
            return false;
        }
    }

    public void printContacts(){
        System.out.println("Contact List:\t");
        for (int i=0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println(i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber() + "\t");
        }
    }
}
