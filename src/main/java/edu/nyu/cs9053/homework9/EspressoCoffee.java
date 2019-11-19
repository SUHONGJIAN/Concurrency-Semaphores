package edu.nyu.cs9053.homework9;

public class EspressoCoffee implements CoffeeDrink{

    private final boolean decaf;

    private final boolean milk;

    public EspressoCoffee() {
        this.decaf = true;
        this.milk = false;
    }

    @Override public boolean isDecaf() {
        return decaf;
    }

    @Override public boolean containsMilk() {
        return milk;
    }
}
