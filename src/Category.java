package FinalOOP;

import java.util.ArrayList;

public class Category {
   private String name; 
    private ArrayList<MenuItem> items;


    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>(); //collections - collection done
    }

    public String getName() {
        return name;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public String toString() {
        return name;
    }
}
