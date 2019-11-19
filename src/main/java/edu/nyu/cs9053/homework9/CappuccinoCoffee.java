package edu.nyu.cs9053.homework9;

public class CappuccinoCoffee implements CoffeeDrink {

    private final boolean decaf;

    private final boolean milk;

    public CappuccinoCoffee() {
        this.decaf = true;
        this.milk = true;
    }

    @Override public boolean isDecaf() {
        return decaf;
    }

    @Override public boolean containsMilk() {
        return milk;
    }
}
