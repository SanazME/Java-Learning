package com.sanaz;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public VipCustomer() {
        this("uknown", 0.0, "unknown@gmail.com");
    }

    public VipCustomer(String name, String email) {
        this(name, 0.0, email);
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
