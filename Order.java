package FinalOOP;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//user input storage
class Order {
    private ArrayList<MenuItem> items;

    public Order(){
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public ArrayList<MenuItem> getItems(){
        return items;
    }

    public double calculateTotal(){
        double total = 0.0;
        for (MenuItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    /* desecrated code
    public String toString(){
        String order = "";
        for (MenuItem item : items){
            order += item + "\n";
        }
        return order;
    }
        */

    public void saveReceipt(){
        if(items.size() == 0){
            System.out.println("No items in cart.");
            return;
        }

        //file handling, can find it in the package folder idk
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "receipt_" + timestamp + ".txt"; 

        try (FileWriter writer = new FileWriter(fileName)){
            writer.write("Receipt\n");
            writer.write("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n"); //"Date: actually gets your date and time in system", cant change this unless we put it as "user" input, would rather not tho
            writer.write("Items:\n");

        //list of orders in receipt
        for(MenuItem item : items){
            writer.write("- " + item.getName() + ": Php " + item.getPrice() + "\n");
        }

        writer.write("\nTotal: Php " + calculateTotal() + "\n"); 
        System.out.println("Receipt saved as " + fileName);
        
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        } 
    }
}