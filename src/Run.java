package FinalOOP;


import java.util.ArrayList;
import java.util.Scanner;

public class Run {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Central menuCentral = new Central();

    //categories, we can add shi here and just add it to cases if so
    Category burger = new Category("Burger");
        burger.addItem(new MenuItem("Classic Burger", 59.99));
        burger.addItem(new MenuItem("Cheeseburger", 69.99));
        burger.addItem(new MenuItem("Infamous Spicy Triple Beef Angus A5 Wagyu Burger", 999.99));
        burger.addItem(new MenuItem("1-inch Pizza Burger", 8.99));

    Category pasta = new Category("Pasta");
        pasta.addItem(new MenuItem("Spaghetti", 80.00));

    Category drinks = new Category("Drinks");
        drinks.addItem(new CustomDrink("Coke", 20.00, false));
        drinks.addItem(new CustomDrink("Sprite", 20.00, false));
        drinks.addItem(new CustomDrink("Iced Tea", 20.00, false ));
        drinks.addItem(new CustomDrink("Water", 0.00, false));
        drinks.addItem(new CustomDrink("Coffee", 30.00, true));

    Category chicken = new Category("Chicken");
        chicken.addItem(new MenuItem("Fried Chicken", 90.00));
        chicken.addItem(new MenuItem("Chicken Parmesan", 120.00));
        chicken.addItem(new MenuItem("Chicken Alfredo", 120.00));
        chicken.addItem(new MenuItem("Barbeque Chicken", 105.00));

        //smart genius way i did so i dont have to make this complex was that we just restrict them from customizing their drink i think
    Category special = new Category("Combo Meals");
        special.addItem(new SpecialCombo("Student Meal - Classic Burger w/ Medium Fries and Coke", 80.00, new CustomDrink("Coke", 0.00, false))); 
        special.addItem(new SpecialCombo("Classic Fast Food - Cheeseburger w/ Medium Fries and Sprite", 90.00, new CustomDrink("Sprite", 0.00, false))); 
        special.addItem(new SpecialCombo("Chicken Meal - 1pc Fried Chicken w/ Coke", 105.00, new CustomDrink("Coke", 0.00, false))); 
   
    menuCentral.addCategory(burger);
    menuCentral.addCategory(pasta);
    menuCentral.addCategory(drinks);
    menuCentral.addCategory(chicken);
    menuCentral.addCategory(special);

    boolean running = true;
    Order currentOrder = new Order();

    while(running){
        System.out.println("\n=== Let Eric Cook ===");
        System.out.println("1. View Menu by Category");
        System.out.println("2. View Current Order");
        System.out.println("3. Checkout");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
            case 1:
                System.out.println("\n == Menu ==\n");
                ArrayList<Category> categories = menuCentral.getCategories();
                for (int i = 0; i < categories.size(); i++){
                    System.out.println((i + 1) + ". " + categories.get(i).getName());
                }
                System.out.print("\nSelect your choice: ");
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();

                if (categoryChoice > 0 && categoryChoice <= categories.size()){
                    Category selectedCategory = categories.get(categoryChoice - 1);
                    System.out.println("\n--- " + selectedCategory.getName() + " ---");
                    ArrayList<MenuItem> items = selectedCategory.getItems();
                    for (int i = 0; i < items.size(); i++){
                        System.out.println((i + 1) + ". " + items.get(i));
                    }

                    System.out.print("Enter item number to add to order (or 0 to go back): ");

                    int itemChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (itemChoice > 0 && itemChoice <= items.size()){
                        MenuItem selectedItem = items.get(itemChoice - 1);

                        if (selectedItem instanceof CustomDrink) {
                            CustomDrink drink = (CustomDrink) selectedItem;
                            System.out.println("Customize your drink:");
                            System.out.println("1. Add Ice (only for cold drinks)");
                            System.out.println("2. Add Additional Sugar");
                            System.out.println("3. No Customization");
                            System.out.print("Choose an option: ");
                            int customizationChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                    
                            switch (customizationChoice) {
                                case 1:
                                    drink.addIce();
                                    break;
                                case 2:
                                    drink.addAdditionalSugar();
                                    break;
                                case 3:
                                    System.out.println("No customization applied.");
                                    break;
                                default:
                                    System.out.println("Invalid choice. No customization applied.");
                            }
                        }

                        currentOrder.addItem(items.get(itemChoice - 1));
                        System.out.println("Item added to your order.");

                    } else if (itemChoice == 0){
                        System.out.println("Going back to main menu.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                } else {
                    System.out.println("Invalid category number.");
                } break;

            case 2:
                System.out.println("\n--- Current Order ---");
                    ArrayList<MenuItem> orderItems = currentOrder.getItems();
                    if (orderItems.isEmpty()) {
                        System.out.println("Your order is empty.");
                    } else {
                        for (MenuItem item : orderItems) {
                            System.out.println("- " + item);
                        }
                        System.out.println("Total: Php " + currentOrder.calculateTotal());
                    }
                    break;

            case 3:
                System.out.println("\n--- Checkout ---");
                ArrayList<MenuItem> checkoutItems = currentOrder.getItems();
                if (checkoutItems.isEmpty()) {
                    System.out.println("Your order is empty. Nothing to checkout.");
                } else {
                    for (MenuItem item : checkoutItems) {
                        System.out.println("- " + item);
                    }
                    System.out.println("Total: Php " + currentOrder.calculateTotal());
                    System.out.println("Would you like to save a receipt? (yes/no): ");
                    String saveReceiptChoice = scanner.nextLine();

                    if (saveReceiptChoice.equalsIgnoreCase("yes")) {
                        currentOrder.saveReceipt();
                    }

                    System.out.println("Thank you for your order!");
                    currentOrder = new Order(); // Reset the order
                }
                break;      
            case 4:
                running = false;
                System.out.println("Exiting the system. Have a great day!");
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
                break;
            }
        }
        scanner.close();
    } 
}
