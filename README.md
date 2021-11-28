# Java-Learning
- To download prebuilt OpenJDK binaries for free: https://adoptopenjdk.net/
- There are two JVMs: HotSpot and OpenJ9.
- There are different distributors of OpenJKD:
  - Amazon Corretto
  - Oracle
  - Azul
  - RedHat
- `String` is a class in Java and default value of `null`.
- Constructors can be overloaded. We can define more than one constructor for a class.
- We can call a constructor within another constructor. One example would be that if a constructor with an empty variables is called, we want to call the second constructor with params and set initial/default value for it params instead. We do it by calling `this(val1, val2, ...)` with default values for params (inputs to other constructors with params):
```java
public class BankAccount{
    
  public BankAccount() {
    this("123234", "345.23", "Bob");
    System.out.println("An empty constructor is called!");
  };
  
  public BankAccount(String account, double balance, String customerName) { 
      System.out.println("Constructor with params is called!");
  }
}
```
- That `this` has to be the first line in the constructor in order to work and to refer to another constructor.
- If you run those line, the output:
```shell
Constructor with params is called!
An empty constructor is called!
```
it first calls the emtpy constructor which first line is a call to the second constructor.

- If we want to default only a subset of params in constructor and not all, we can again use `this`:
```java
public class BankAccount {
  public BankAccount(String customerName, String email, String phoneNumber) {
    this("99999", 100, customerName, email, phoneNumber);
  }

  public BankAccount(String account, double balance, String customerName) {
    System.out.println("Constructor with params is called!");
  }
}
```

- Generally we have one major constructor that update all the fields and then other constructors should call that major constructor.

- There are two opinions on how to set the constructor values to the fields in a class:
  1. set the value directly to the field: ```this.name = name```
  2. use a setter: ```setName(name);```;
  
  the first approach is preferred because it always works in case of ingeritance and subclassing.


