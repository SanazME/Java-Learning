package com.sanaz;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers;
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGrocery(String item){
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceries(){
        System.out.println(groceryList);
    }

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

    public void removeGrocery(String item){
        int idx = findItem(item);
        if (idx >= 0){
            removeGrocery(idx);
        } else {
            System.out.println(item + " is not found in the list.");
        }
    }
    private void removeGrocery(int position){
        try {
            String item = groceryList.get(position);
            groceryList.remove(position);

            System.out.println("Item " + item + " has been removed.");

        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem){
        int idx = findItem(searchItem);
        if (idx >= 0){
            return true;
        } else {
            return false;
        }
    }

}
