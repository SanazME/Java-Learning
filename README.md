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


- When a Class `extend` another one (inherits from another one), we need to call the constructor of another class for initialization.
- `super` is to call the constructor of the class that we're extending from. SO we can initialize the base class.
```java
 public class Dog extends Animal {
  // Unique characteristic of Dog class apart from Animal base class
  private int eyes;
  private int legs;
  private int tail;
  private int teeth;
  private String coat;
  
  public Dog(int brain, int body, int size, int weight, String name) {
    super(brain, body, size, weight, name);
  }
}
```
- Since the Dog class also has params need to be initialized in additon to those from Animal class, we can remove some of base class params from Dog constructor input and pass in some default values to the base class instead:
```java
 public class Dog extends Animal {
  // Unique characteristic of Dog class apart from Animal base class
  private int eyes;
  private int legs;
  private int tail;
  private int teeth;
  private String coat;
  
  public Dog(int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat) {
    super(1, 1, size, weight, name);

    this.eyes = eyes;
    this.legs = legs;
    this.tail = tail;
    this.teeth = teeth;
    this.coat = coat;
  }
}
```

- In Dog class, we can use `Override methods...` to override methods available from base class for our child/Dog class.
- `java.lang.Object` Every single class that we create, even though it doesn't come up and show you via the use of `extends` keyword, it does actually get extended from this Java class: `java.lang.Object`.