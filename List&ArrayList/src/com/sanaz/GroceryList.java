package com.sanaz;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers;
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGrocery(String item){
        groceryList.add(item);
    }

    public void printGroceries(){
        System.out.println(groceryList);
    }

    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
    }

    public void removeGrocery(int position){
        try {
            String item = groceryList.get(position);
            groceryList.remove(position);

            System.out.println("Item " + item + " has been removed.");

        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    public String findItem(String searchItem){
        boolean exists = groceryList.contains(searchItem);
        if (exists){
            return searchItem;
        } else {
            System.out.println( searchItem + " was not found in the grocery list!");
            return null;
        }
    }

}
