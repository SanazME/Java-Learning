package com.sanaz;

public class Main {

    public static void main(String[] args) {
	    GroceryList groceryList = new GroceryList();

        groceryList.addGrocery("apple");
        groceryList.addGrocery("orange");
        groceryList.modifyGroceryItem(1, "banana");

        groceryList.printGroceries();

        // Removing an item
        groceryList.addGrocery("cherries");
        groceryList.addGrocery("avocado");

        groceryList.printGroceries();

        groceryList.removeGrocery(5);
        groceryList.printGroceries();

        // Find an item
        groceryList.findItem("banana");
        groceryList.findItem("hammer");
    }
}
