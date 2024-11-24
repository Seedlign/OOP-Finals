package FinalOOP;

//used when special combo
class SpecialCombo extends MenuItem {
    private CustomDrink drink;

    public SpecialCombo(String name, double price, CustomDrink drink) {
        super(name, price);
        this.drink = drink;
    }

    public CustomDrink getDrink() {
        return drink;
    }

    public void setDrink(CustomDrink drink) {
        this.drink = drink;
    }

    public String toString() {
        String drinkDetails = (drink != null) ? " + " + drink.toString() : "";
        return super.toString() + drinkDetails;
    }
}
