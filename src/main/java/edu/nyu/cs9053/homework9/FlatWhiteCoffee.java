package edu.nyu.cs9053.homework9;

public class FlatWhiteCoffee implements CoffeeDrink {

    private final boolean decaf;

    private final boolean milk;

    public FlatWhiteCoffee() {
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
