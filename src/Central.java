package FinalOOP;

import java.util.ArrayList;

//central class for categories, what goes in the category of the menus goes here or sumthing
public class Central {
    private ArrayList<Category> categories; 

    public Central() {
        categories = new ArrayList<>(); 
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
