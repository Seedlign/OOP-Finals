package FinalOOP;

class CustomDrink extends MenuItem {
    private boolean isHot;
    private boolean hasIce;
    private boolean hasAdditionalSugar;

    public CustomDrink(String name, double price, boolean isHot) {
        super(name, price);
        this.isHot = isHot;
        this.hasIce = false;
        this.hasAdditionalSugar = false;
    }

    public boolean isHot() {
        return isHot;
    }

    public boolean hasIce() {
        return hasIce;
    }

    public boolean hasAdditionalSugar() {
        return hasAdditionalSugar;
    }

    public void addIce() {
        if (!isHot) {
            this.hasIce = true;
        } else {
            System.out.println("Ice cannot be added to a hot drink.");
        }
    }

    public void addAdditionalSugar() {
        this.hasAdditionalSugar = true;
    }

    public String toString() {
        String temperature = isHot ? "Hot" : "Cold";
        String additionalOptions = "";
        if (!isHot && hasIce) {
            additionalOptions += " + Ice";
        }
        if (hasAdditionalSugar) {
            additionalOptions += " + Sugar";
        }
        return super.toString() + " [" + temperature + additionalOptions + "]";
    }
}
