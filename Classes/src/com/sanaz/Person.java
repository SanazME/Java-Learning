package com.sanaz;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if ( 0 <= age && age <= 100){
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public boolean isTeen() {
        return (this.age > 12 && this.age < 20);
    }

    public String getFullName() {

        if (!firstName.isEmpty()) {
            if (!lastName.isEmpty()) {
                return firstName + " " + lastName;
            } else {
                return firstName;
            }
        } else {
            if (!lastName.isEmpty()) {
                return lastName;
            } else {
                return "";
            }
        }
    }
}
