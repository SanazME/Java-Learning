package com.sanaz;

public class Contact {
    private String name;
    private String phoneNumber;

    private Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Static factory method for creating Contact instance
    // we want to creat a new contact record without creating a new Contact object to call the method on it
    public static Contact newInstance(String name, String phoneNumber){
        return new Contact(name, phoneNumber);
    }

}
