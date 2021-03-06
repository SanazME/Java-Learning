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

- we can directly call a Base class method in the child class:
```java
public class Animal{
    //...
    public void move(int speed){
      System.out.println("Animal is moving at: " + speed);
    }
}

public class Dog extends Animal{
    // ...
    public void walk(){
      System.out.println("Dog.walk() is called");
      move(5);
    }
}
```
- If we use `super.move(4)` instead of `move(5)` in Dog class. We need to create some unique characteristic for Dog in move. We see that in `run` method, we don't use `super.move()` and just `move` and since we defined `move` method in Dog class now, it first tried to find the method within the class and if it doesn't it goes to run the superclass one:
```java
- public class Animal{
  //...
  public void move(int speed){
    System.out.println("Animal is moving at: " + speed);
  }
}

public class Dog extends Animal{
  // ...
  public void walk() {
    System.out.println("Dog.walk() is called");
    super.move(5);
  }

  public void run(){
    System.out.println("Dog.run() is called");
    move(10);
  }

  private void moveLegs(int speed){
    System.out.println("Dog.moveLegs() is called");
  }

  @Override
  public void move(int speed) {
    System.out.println("Dog.move() called.");
    moveLegs(speed);
    super.move(speed);
  }
}

//dog.run();
/* output order:
 * Dog.run() is called
Dog.move() called.
Dog.moveLegs() is called
Animal is moving at: 10
 * */
```
- if we comment out the `@Override` code to remove `move` method from Dog class and rerun, we see that it now runs `move` method from super:
`Dog.run() is called
  Animal is moving at: 10`
- In Java, we always have references to objects in memory and we can reference or dereference them by assigning a reference to a new object.

- `this` vs `super`: 
  - `this` is used to access/call the current class members (variables and methods)
  - `super` is used to access/call the parent class members (variables or methods)
  - We can use both of them anywhere in a class except **static areas(static methods of static blocks)**.

- `this` is commonly used with **constructors** and **setters** and optionally for **getters** (easier for beginners).
```java
class House {
    private String color;
    
    public House(String color){
        // this keyword is required
      this.color = color;
    }
    
    public String getColor(){
        // this is optional
      return color; // similar as this.color
    }
    
    public void setColor(String color){
        // this is required.
      this.color = color;
    }
}
```

- `super` is commonly used with **method overriding**, when we call a method with the same name from the parent class.

```java
class SuperClass {
  public void printMethod() {
    System.out.println("Printed in Superclass");
  }
}

  class SubClass extends SuperClass {
    // Overrides method from parent
    @Override
    public void printMethod() {
      super.printMethod(); // calls method in SuperClass
      System.out.println("Printed in SubClass");
    }
  }
  
  class MainClass{
    public static void main(String[] args){
        SubClass s = new SubClass();
        s.printMethod();
    }
  }
```

### this() vs. super() method calls
- Use `this()` to call a constructor from another overloaded constructor in the same class.
- The call to `this()` can be **used only in a constructor, and it must be the first statement in a constructor**.
- it's uses with constructor chaining, when one constructor calls another constructor and helps to reduce duplicated code.

- **In constructor chaining, always one constructor is responsible for initialization variables and does all the work. The other constructors make calls to other ones.**

- **The only way to call a parent constructor is by calling `super()`. This calls the parent constructor**
- The Java Compiler puts a **default call to `super()`** if we don't add it, and it's always the no-args `super` which is inserted by compiler.
- **The call to `super()` must be the first statement in each constructor.**
- Even **Abstract classes** have constructors, although you can never instantiate an abstract class using `new` keyword.
- An Abstract class is still a `super` class, so its constructors run when someone makes an instance of a concrete subclass.
- **A constructor can have a call to `super()` or `this()` but never both.**

### super() and this() example
- In `Rectangle` the first constructor makes call to the second constructor. 
- The second constructor makes call to parent constructor with params x and y. 
- The parent constructor will initialize x, y variables while the second `Rectangle` constructor will initialize the width and height variables.

```java
class Shape {
  private int x, y;

  public Shape(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Rectangle extends Shape {
  private int width, height;

  // 1st constructor
  public Rectangle(int x, int y) {
    this(x, y, 0, 0); // calls 2nd constructor
  }

  // 2nd constructor
  public Rectangle(int x, int y, int width, int height){
      super(x, y); // calls constructor from parent 
    this.height = height;
    this.width = width;
  }
}
```

## Method Overloading vs Method Overriding

### 1. Method Overloading
- it means providing two or more separate methods in a class with the **same name but different parameters**.
- Method return type **may or may not be different** and that allows us to **reuse** the same method name.
- Overloading is very handy, it reduces duplicated code and we don't have to remember multiple names.

- Overloading does not have anything to do with **polymorphism** but Java developers often refer to overloading as **Compile Time Polymorphism**.
- In another words, the compile decided which method is going to be called based on the method name, return type and argument list.
- We **can overload static and instance methods**.

- Usually overloading happens inside a single class but a method can also be treated as overloaded in the subclass of that class.
- That is because a **subclass inherits** one version of the method from the parent class and then the subclass can have another overloaded version of the method.

### 1.2. Method Overloading Rules

- Methods will be considered overloaded if both follow the following rules:
  - Methods must have the same method name.
  - Methods must have different parameters.
- If methods follow the rules above then they may or may not:
  - Have different return types
  - Have different access modifiers (`Default, Private, Protected, Public`)
  - Throw different checked or unchecked execeptions.

### 2. Method Overriding
- Method overriding means defining a method in a child class that already exists in the parent class with **the same signature (same name, same arguments)**
- by extending parent class, the child class gets all the methods defined in the parent class (those methods are also known as derived methods).

- Method overriding is also known as **Runtime Polymorphism** and **Dynamic Method Dispatch**, because the method that is going to be called is decided at runtime by the JVM.

- **We can't override static methods. Only instance methods.**

### 2.2. Method Overriding Rules
- Method will be considered overriden if we follow these rules:
  - It must have same name and same arguments
  - Return type can be a sublass of the return type in the parent class.
  - It can't have a lower access modifier.
  - For example if the parent method is protected then using private in the child is not allowed but using public in the child would be allowed.

## 2.3 Method Overriding important points
- **Only inherited methods can be overriden**, meaning methods can be overriden only in child classes.
- **Constructors and private methods cannot be overriden.**
- Methods that are final cannot be overriden.
- A subclass can use `super.methodName()` to call the superclass version of an overriden method.

- **we can overload static methods but we cannot override static methods.**
![Comparison](Comparison.png)
- Covariant return type, means that the Overriden method can return any child type of the parent method type:
![Covariant type](covariant.png)

## Static Methods vs. Instance Methods
### 1. Static Methods
- Static methods are declared using a `static` modifier.
- **Static methods can't access instance methods and instance variables directly**
- They are usually used for **operations that don't require any data from an instance of the class (from `this`)**. (`this` is the current instance of a class).

- In static methods we cannot use the `this` keyword.
- Whenever you see a method that **does not use instance variables** that method should be declared as a **static method**.
- For example `main` is a static method and it is called by JVM when it starts an application.
- ![staticMethod](staticMethod.png)

### 2. Instance Methods
- Instance methods belong to an instance of a class.
- To use an instance method, we have to instantiate the class first usually by using the `new` keyword.
- Instance methods can access instance methods and instance variables directly.
- Instance methods can also access **static methods and static variables directly**.
![shouldStatic](shouldStatic.png)

## Static Variables vs Instance Variables
- Declared by using the keyword `static`.
- Static variables are also known as `static member variables`
- Every instance of that class **shares the same static variable**.
- **If changes are made to that variable, all other instacens will see the effect of the change.**
- Static variables are not used very often but can sometimes be very useful.
- For example when reading user input using `Scanner` we will declare scanner as a static variable.
- That way **static methods can access it directly.**
  ![staticVar](staticVar.png)

- **Instance variables represent the state of an instance.**

## Static method and Static variable (part 2)
- A static variable is a variable that remembers its value in between uses. It's created outside of a method and methods can interact with it and change the value at will but instead of being destroyed after the method is done the variable remains unchanged until the next method comes along to modify it.

- A static method on the other hand is a method that is a member of a class but is capable of standing alone. Normally when working with objects you have to create an instance of an object in order to call the methods that it contains. An example of this is `Car car = new Car()`; This creates a new instance of the `Car` class type and stores it in a variable called `car`. Then you call methods belonging to that class by running `car.methodName()` Because static methods are standalone that means you can call them without creating a new instance of the class type. You do this by specifying the class then method name.` Car.methodName()` This runs the method `methodName` inside the `Car` class, **but doesn't need to create a new Car in order to do it**.

```java
public Contact{
    
 public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}

Contact newContact = Contact.createContact(name, phone);
```
- The code that you pasted up above is a "stand alone" method that creates a new instance of a Contact object and passes it back to the code that called it. This allows you to create a new Contact without needing to make a temporary instance of the class that createContact() belongs to before calling the method.

## Composition
- **Inheritance is a "IS" relationship**. For example, Car (class) IS a Vehicle (parent class).
- **Composition is a "HAS" relationship.** For example, Car (class) HAS steering wheel (another class), HAS Engine (another class) etc.
- With Inheritace (`extend`), we can only inherit from one class at a time but with composition we can use HAS relationship and use many classes within a class.
- For example, Monitor class Has a Resolution but it IS NOT Resolution:
```java
public class Monitor {
  private String model;
  private String manufacturer;
  private int size;
  private Resolution nativeResolution;
  //
}
```

- PC has Monitor, Motherboard and Case:
```java
public class PC {
    private Motherboard motherboard;
    private Case TheCase;
    private Monitor monitor;

    // constructor receives objects of those class types
    public PC(Motherboard motherboard, Case theCase, Monitor monitor) {
        this.motherboard = motherboard;
        TheCase = theCase;
        this.monitor = monitor;
    }

    // getters return object of that class
    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Case getTheCase() {
        return TheCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
```
- In order to access a method from a class:
```java
public class Main {

    public static void main(String[] args) {
        Motherboard motherboard = new Motherboard("X12", "someManufacturer", 4, 5, "BIOX");

        Case myCase = new Case("model", "man", "power", new Dimensions(23, 10, 5));

        Monitor monitor = new Monitor("model", "man", 23, new Resolution(33, 22));

	    PC myPc = new PC(motherboard, myCase, monitor);

        // To access a method of a class
        myPc.getMonitor().drawPixelAt(22, 25, "Blue");
        myPc.getMotherboard().loadProgram("Star War!");
    }
}
```
- But we don't want to define those method to access classes public so our `Main` class won't have access to those. So we change access pattern from `public` to `private` in our `PC` class and instead define public methods there to make call to other class instances or just get rid of those getters instead:
```java
public class PC {
  private Motherboard motherboard;
  private Case TheCase;
  private Monitor monitor;

  public PC(Motherboard motherboard, Case theCase, Monitor monitor) {
    this.motherboard = motherboard;
    TheCase = theCase;
    this.monitor = monitor;
  }

  public void powerUp() {
    TheCase.pressPower();
    drawLogo();
  }

  public void drawLogo() {
    // Fancy graphics
    monitor.drawPixelAt(1200, 50, "yellow");
  }
}

public class Main {

  public static void main(String[] args) {
    Motherboard motherboard = new Motherboard("X12", "someManufacturer", 4, 5, "BIOX");
    Case myCase = new Case("model", "man", "power", new Dimensions(23, 10, 5));
    Monitor monitor = new Monitor("model", "man", 23, new Resolution(33, 22));
    PC myPc = new PC(motherboard, myCase, monitor);

    // To access a method of a class
    myPc.powerUp();
  }
}
```
## Encapsulation
- By defining a constructor, we can add validations on each field and also set an initial values for the fields. So this way, we make sure that when the object is instantiated, the fields have valid values.
- Also with a `getter` we can restrict access to the fields of a class.

## Polymorphism
1. Compile time/Static Polymorphism: method Overloading
2. Runtime/Dynamic Polymorphism: method Overriding

- In Java to get a class name within its methods we can use `getClass().getSimpleName()`

## Arrays
```java
public class Main {
  public static void main(String[] args) {
    // Approach 1
    int[] myVariable;
    myVariable = new int[10];

    // Approach 2
    double[] myVar2 = new double[20];

    // Approach 3
    int[] myVar3 = {1,2,3,4,5,6};
    
    // Length of an array
    myVariable.length

  }
  
 // To get inputs from users and save them in an array
 //For example, this code allows a user to read a number from System.in:
 private static Scanner scanner = new Scanner(System.in);

    /*
    * As another example, this code allows long types to be assigned from entries in a file myNumbers:

      Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }
    * */

  public static int[] getIntegers(int number){
    System.out.println("Enter " + number + " integer values.\r");
    int[] values = new int[number];

    for (int i=0; i < values.length; i++){
      values[i] = scanner.nextInt();
    }

    return values;
    
  }
}
```
- To print contents of an array (since it's an object): `Arrays.toString(arr)`
- To make sure the returned type is `double` and not `int`, type casting: `(double) sum / (double) arr.length`
- To make a copy of an array instead of a `for` loop: `int[] sortedArr = Arrays.copyOf(arr, arr.length);`
- For **boolean** array elements are initialized to **False**.
- For **string or other objects** that would be **null**.

## Reference Types vs Value Types
- Primitives like `int`, `double` and `boolean` have Value types. When we create a variable with a primitive value and then create another variable with a copy of the first variable. The value is copied to memory and they work independently.

- Any object (anything created using `new`) has Reference type. Like Arrays, objects, strings... The reference holds a reference/address to the object in memory (but not hold the object itself). So if we copy the variable and try to change its value, it will affect all other variables referring to the same object. 

- We use `myArr = new int[]{3,4,5}`, we **deference the array to point to another address in memory**

## List
- In general (and in Java) an array is a **data structure** generally consisting of sequential memory storing a collection of objects.
- **List** is an **interface** in Java, which means that it may have multiple implementations.
  - One of these implementations is `ArrayList`, which is a class that implements the behavior of the `List` interface using `Arrays` as the data structure.
  - There are a number of other classes that implement the `List` interface. Like: `AbstractList, AbstractSequentialList, ArrayList, AttributeList, CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector`
  - Look at doc: https://docs.oracle.com/javase/8/docs/api/java/util/List.html

## ArrayList
- ArrayList is a part of collection framework and is present in `java.util` package. It provides us with dynamic arrays in Java. Though, it may be slower than standard arrays but can be helpful in programs where lots of manipulation in the array is needed.
- Unlike Arrays that we had to define the type when declaring them (`int[] myNUmbers`), We define ArrayList and the type of the **object** that goes inside because an ArrayList can hold objects. So instead of defining the type of the array, we define the type of data that goes inside ArrayList.
- for ArrayList, we don't create a different type of ArrayList like `String ArrayList`. Instead, we define an ArrayList and then the type of objects going inside it : `private ArrayList<String>`.
- `private ArrayList<String> groceryList = new ArrayList`
- Unlike Array, ArrayList is a class so it has its own constructor.
`private ArrayList<String> groceryList = new ArrayList<String>();`

- `scanner.nextLine();` clear the next line and clears buffer.
- `next()` can read the input only till the space. It can't read two words separated by a space. Also, `next()` places the cursor in the same line after reading the input.
- `nextLine()` reads input including space between the words (that is, it reads till the end of line `\n`). Once the input is read, `nextLine()` positions the cursor in the next line.
- For reading the entire line you can use `nextLine()`.
- A useful tool for parsing data from `nextLine()` would be `str.split("\\s+")`.

```java
String data = scanner.nextLine();
String[] pieces = data.split("\\s+");
// Parse the pieces
```

- Advances this scanner past the current line and returns the input that was skipped. This method returns the rest of the current line, excluding any line separator at the end. The position is set to the beginning of the next line.


- In the `GroceryList.java` we had first implemented `modifyGroceryItem` which required position and newItem. But we wanted to leave the details of implementation to that class and in the `Main` the user does not need to know how the list and items are in the list implemented. So In `Main` we defined `modifyItem` method which gets the current and new item and pass it down to  `modifyGroceryItem` method in `GroceryList.java`.
- But in `GroceryList.java` we then overload that method which gets oldItem and newItem (instead of position) and find the position and calls the first method:
```java
public void modifyGroceryItem(String oldItem, String newItem){
        int idx = findItem(oldItem);

        if (idx >= 0){
            modifyGroceryItem(idx, newItem);
        } else {
            System.out.println(oldItem + " not found!");
        }
    }

    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
    }
```

- To get a content of an ArrayList from our Grocery class, we define a getter for our ArrayList `groceryList` in that Grocery class and then in `Main` create a new ArrayList and add all elements from that getter ArrayList to the new one:
```java
// GroceryList class
public class GroceryList {
  private ArrayList<String> groceryList = new ArrayList<String>();
  
  public ArrayList<String> getGroceryList() {
    return groceryList;
  }
}

// Main class
public class Main {

  private static GroceryList groceryList = new GroceryList();

  public static void processArrayList() {
    // create a new array list
    ArrayList<String> newArr = new ArrayList<String>(groceryList.getGroceryList());
    // OR
    ArrayList<String> newArray = new ArrayList<String>();
    newArray.addAll(groceryList.getGroceryList());

    
  }
}
```

- To add all elements from one ArrayList to another: `newArr.addAll(oldArr)`
- Or at the point of creating a new ArrayList: `ArrayList<String> newArr = new ArrayList<String>(oldArr)`
- This creates a new arraylist initialized with the content of the old arraylist.

- To convert an ArrayList to Array:
```java
// Convert an ArrayList (object) to Array
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
```

## Linked List
- In a list/array of integers, internally, java will allocate **4 bytes of memory for each integer value.** 
- Java tries to do it **contiguously**. It uses the formula to figure out which memory address to save the item into:
`index * 4(bytes) + Address of the first element`:
- ![List of integers](linkedListInt.png)
- It is similar for a list of double, java uses up to **8 bytes of memory for each double value**.
- For a list of Strings (variable size) and objects. The memory allocated in the array is 8 bytes but it actually points to another location in memory where the string is. 
- The actual strings and their addresses are not saved contiguously but the address to their addresses are saved contiguously in the indexed array:
- ![List of strings/objects](linkedListString.png)

- Linked list has the value and address of that value + pointer to point to the next item:
![Linked list](linkedList.png)


## Singleton Class 
- a singleton class is a class that can have only one object (an instance of the class) at a time.
  After first time, if we try to instantiate the Singleton class, the new variable also points to the first instance created. So whatever modifications we do to any variable inside the class through any instance, it affects the variable of the single instance created and is visible if we access that variable through any variable of that class type defined. 
- The key points in defining singleton class:
  1. Make constructor private
  2. Write a static method that has return type object of this singleton class. 

- Here's the Singleton idion:
```java
public class MyClass {
    private static final MyClass myClass = new MyClass();

    private MyClass() {}

    public static MyClass getInstance() {
        return myClass; 
    }
}
```
- It should be:
  - `private`: so that nobody else can access it directly.
  - `static`: so that there's only one of it.
  - `final`: so that it cannot be reassigned.
  - You also need to instantiate it **directly during declaration** so that you don't worry about threading.
- 
- If the loading is expensive and you thus rather prefer lazy loading of the Singleton, then consider `Singelton holder (initialization-on-demand holder)` which does initialization on demand instead of during classloading:
```java
public class MyClass {
    private MyClass() {}

    private static class LazyHolder {
        private static final MyClass myClass = new MyClass();
    }

    public static MyClass getInstance() {
        return LazyHolder.myClass;
    }
}
```

## Static Factory methods instead of Constructors
- A class can provide a **public static factory method** which is simply **a static method that returns an instance of the class.**
```java
public static Foo of(....) {return new Foo(..)} 
```

### Static factory method vs. Singleton objects
- A static factory method may return new instances, alternate sublcasses of a type, wrap critical logging or registry, compose a number of items into an object, or return back a single static instance.

- They are not required to create a new object each time they're invoked. Unlike `new` which always creates a new object, a factory method could be implemented in some more clever way that reuses an existing object.

- A singleton obtained by any means always resolves back to the same instance. This means there is no variability.

**Advantages**
1. static facotry methods, unlike constructors, have names (`of`, `from`, `valueOf`, `getInstance`, `newInstance`, `type`)
2. Unlike constructors, they are not required to create a new object each time they're invoked.
  - this allows immutable classes to use preconstructed instances or to cache the instances as they're constructed.

3. Unlike constructors, they can **return an object of any subtype of their return type**
4. The class of the returned object can vary from call to call as a function of the input parameters.
  - any subtype of the declared return type is permissible. The class of the returned object can also vary from release to release.
**Disadvantages**
  - classes without public or protected constructors cannot be subclasses.
  - they are hard for programmers to find.

## Difference between an Interface and Abstract class: 
- https://stackoverflow.com/questions/1913098/what-is-the-difference-between-an-interface-and-abstract-class

## Autoboxing and Unboxing
- Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an `int` to an `Integer`, a `double` to a `Double`, and so on. If the conversion goes the other way, this is called unboxing.
```java
Integer myInVal = 56: // at compile time it changes to (autoboxing) --> Integer.valudOf(4)
int myIntVal = myInVal;  // myInVal.intValue() unboxing at compile time: convert Integer class type back to primary type
```

**To compare two strings ignoring case sensitivity**:
```java
s1.equalsIgnoreCase(s2) // "HeLLo" == "hello" returns boolean
```

## Nested Classes
- https://www.tutorialspoint.com/java/java_innerclasses.htm
- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example

- Nested classes are divided into 2 categories:
  1. Inner classes (Non-static nested classes)
     1. Inner classes
     2. Local Inner classes (defined in a **block {}**: inside a method, `for` loop, `if` clause)
     3. Anonymous classes (declare and instantiate a class at the same time)
  2. Static nested classes

- **Why using nested classes?**
  - **It is a way of logically grouping classes that are only used in one place**: If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined.

  - **It increases encapsulation**: Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.

  - **It can lead to more readable and maintainable code**: Nesting small classes within top-level classes places the code closer to where it is used.

### 1.1 Inner Classes
- Inner classes are a security mechanism in Java. We know a class cannot be associated with the access modifier **private**, but if we have the class as a member of other class, then the inner class can be made private. And this is also used to access the private members of a class.
```java
class Outer_Demo {
   int num;
   
   // inner class
   private class Inner_Demo {
      public void print() {
         System.out.println("This is an inner class");
      }
   }
   
   // Accessing the inner class from the method within
   void display_Inner() {
      Inner_Demo inner = new Inner_Demo();
      inner.print();
   }
}
   
public class My_class {

   public static void main(String args[]) {
      // Instantiating the outer class 
      Outer_Demo outer = new Outer_Demo();
      
      // Accessing the display_Inner() method.
      outer.display_Inner();
   }
}
```
#### Accessing the Private Members
- As mentioned earlier, inner classes are also used to access the private members of a class. Suppose, a class is having private members to access them. Write an inner class in it, return the private members from a method within the inner class, say, getValue(), and finally from another class (from which you want to access the private members) call the getValue() method of the inner class.

To instantiate the inner class, initially you have to instantiate the outer class. Thereafter, using the object of the outer class, following is the way in which you can instantiate the inner class.

```java
Outer_Demo outer = new Outer_Demo();
Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();
```
- The following program shows how to access the private members of a class using inner class.
```java
class Outer_Demo {
   // private variable of the outer class
   private int num = 175;  
   
   // inner class
   public class Inner_Demo {
      public int getNum() {
         System.out.println("This is the getnum method of the inner class");
         return num;
      }
   }
}

public class My_class2 {

   public static void main(String args[]) {
      // Instantiating the outer class
      Outer_Demo outer = new Outer_Demo();
      
      // Instantiating the inner class
      Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();
      System.out.println(inner.getNum());
   }
}
// output: This is the getnum method of the inner class: 175
```

### 1.2 Method-local Inner Classes
- They are defined in a **block {}**: inside a method, `for` loop, `if` clause.
- In Java, we can write a class within a method and this will be a local type. Like local variables, the scope of the inner class is restricted within the method.
- A method-local inner class can be instantiated only within the method where the inner class is defined. The following program shows how to use a method-local inner class.

```java
public class Outerclass {
   // instance method of the outer class 
   void my_Method() {
      int num = 23;

      // method-local inner class
      class MethodInner_Demo {
         public void print() {
            System.out.println("This is method inner class "+num);	   
         }   
      } // end of inner class
	   
      // Accessing the inner class
      MethodInner_Demo inner = new MethodInner_Demo();
      inner.print();
   }
   
   public static void main(String args[]) {
      Outerclass outer = new Outerclass();
      outer.my_Method();	   	   
   }
}

// output: This is method inner class 23
```
### 1.3 Anonymous Classes
- An inner class declared without a class name is known as an anonymous inner class. In case of anonymous inner classes, we declare and instantiate them at the same time. **Generally, they are used whenever you need to override the method of a class or an interface**. The syntax of an anonymous inner class is as follows
```java
AnonymousInner an_inner = new AnonymousInner() {
   public void my_method() {
      ........
      ........
   }   
};
```
- The following program shows how to:
  - override the method of an abstract class using anonymous inner class. 
  - In the same way, you can override the methods of the concrete class as well as ,
  - the interface using an anonymous inner class.

:
```java
abstract class AnonymousInner {
   public abstract void mymethod();
}

public class Outer_class {

   public static void main(String args[]) {
      AnonymousInner inner = new AnonymousInner() {
         public void mymethod() {
            System.out.println("This is an example of anonymous inner class");
         }
      };
      inner.mymethod();	
   }
}
// output: This is an example of anonymous inner class
```

### 1.3.1 Anonymous Inner Class as Argument
- Generally, if a method accepts **an object** of:
  - an interface, 
  - an abstract class, or 
  - a concrete class, 
  - 
then we can:
  - implement the interface, 
  - extend the abstract class, 
  - pass the object to the method. 

**If it is a class, then we can directly pass it to the method.**

- But in all the three cases, you can **pass an anonymous inner class to the method**. Here is the syntax of passing an anonymous inner class as a method argument:
```java
obj.my_Method(new My_Class() {
   public void Do() {
      .....
      .....
   }
});
```
- Example:
```java
// interface
interface Message {
   String greet();
}

public class My_class {
   // method which accepts the object of interface Message
   public void displayMessage(Message m) {
      System.out.println(m.greet() +
         ", This is an example of anonymous inner class as an argument");  
   }

   public static void main(String args[]) {
      // Instantiating the class
      My_class obj = new My_class();

      // Passing an anonymous inner class as an argument
      obj.displayMessage(new Message() {
         public String greet() {
            return "Hello";
         }
      });
   }
}
// output: Hello, This is an example of anonymous inner class as an argument
```

### 2. Static nested classes
- A static inner class is a nested class which is a static member of the outer class. It can be accessed without instantiating the outer class, using other static members. Just like static members, a static nested class does not have access to the instance variables and methods of the outer class.
- The syntax of static nested class is as follows ???
- Syntax:
```java
class MyOuter {
   static class Nested_Demo {
   }
}
```
```java
public class Outer {
   static class Nested_Demo {
      public void my_method() {
         System.out.println("This is my nested class");
      }
   }
   
   public static void main(String args[]) {
      Outer.Nested_Demo nested = new Outer.Nested_Demo();	 
      nested.my_method();
   }
}
```
- Another example:
```java
public class OuterClass {

  String outerField = "Outer field";
  static String staticOuterField = "Static outer field";

  class InnerClass {
    void accessMembers() {
      System.out.println(outerField);
      System.out.println(staticOuterField);
    }
  }

  static class StaticNestedClass {
    void accessMembers(OuterClass outer) {
      // Compiler error: Cannot make a static reference to the non-static
      //     field outerField
      // System.out.println(outerField);
      System.out.println(outer.outerField);
      System.out.println(staticOuterField);
    }
  }

  public static void main(String[] args) {
    System.out.println("Inner class:");
    System.out.println("------------");
    OuterClass outerObject = new OuterClass();
    OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    innerObject.accessMembers();

    System.out.println("\nStatic nested class:");
    System.out.println("--------------------");
    StaticNestedClass staticNestedObject = new StaticNestedClass();
    staticNestedObject.accessMembers(outerObject);

    System.out.println("\nTop-level class:");
    System.out.println("--------------------");
    TopLevelClass topLevelObject = new TopLevelClass();
    topLevelObject.accessMembers(outerObject);
  }
}

// TopLevelClass.java
public class TopLevelClass {

  void accessMembers(OuterClass outer) {
    // Compiler error: Cannot make a static reference to the non-static
    //     field OuterClass.outerField
    // System.out.println(OuterClass.outerField);
    System.out.println(outer.outerField);
    System.out.println(OuterClass.staticOuterField);
  }
}
/**
 * Inner class:
 ------------
 Outer field
 Static outer field

 Static nested class:
 --------------------
 Outer field
 Static outer field

 Top-level class:
 --------------------
 Outer field
 Static outer field

 */
```

### Shadowing
- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example

### Serialization
- (https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example)
- Serialization of inner classes, including local and anonymous classes, is strongly discouraged. When the Java compiler compiles certain constructs, such as inner classes, it creates synthetic constructs; these are classes, methods, fields, and other constructs that do not have a corresponding construct in the source code. Synthetic constructs enable Java compilers to implement new Java language features without changes to the JVM. However, synthetic constructs can vary among different Java compiler implementations, which means that `.class` files can vary among different implementations as well. Consequently, you may have compatibility issues if you serialize an inner class and then deserialize it with a different JRE implementation. See the section Implicit and Synthetic Parameters in the section Obtaining Names of Method Parameters for more information about the synthetic constructs generated when an inner class is compiled.

## Lambda Expression
- They can only be used with interfaces that contain only one method that has to be implemented. Why? 
- because the compiler needs to match a lambda expression to a method.
- So these interfaces (with only one method to be implemented) are also called as **@FunctionalInterfaces** in the documentations like in `Comparator` docs.
- In the following examples, instead of options1 or 2, we can use Lambda expression and not defining a class in order to use the only `run` method of class `Runnable`:
```java
public class Main {

    public static void main(String[] args) {
        // option 1: define a concrete class
	    new Thread(new CodeToRun()).start();
        
        // option 2: anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable");
            }
        }).start();
        
        // option 3. Lambda expression - multiple lines
        new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();
    }
}

class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
```
- For example for comparing name of employees and sort them based on their name in ascending order, we can use Comparators as a functional interface (lambda):
```java
public class Main {

  public static void main(String[] args) {
    //*** sorting employees in ascending order WITHOUT using Lambda
    Collections.sort(employeeList, new Comparator<Employee>() {
      @Override
      public int compare(Employee employee1, Employee employee2) {
        return employee1.getName().compareTo(employee2.getName());
      }
    });

    for (Employee employee : employeeList){
      System.out.println(employee.getName());
    }

    // *** sorting employees in ascending order WITH using Lambda
    Collections.sort(employeeList, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

    for (Employee employee : employeeList){
      System.out.println(employee.getName());
    }
    
  }
}
```