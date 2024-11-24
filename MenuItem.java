package FinalOOP;

//encapsulates name and price of menu - encapsulation done - basically the parent class of every menu
public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " - Php " + price;
    }
}