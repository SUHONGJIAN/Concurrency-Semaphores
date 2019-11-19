package edu.nyu.cs9053.homework9;

/**
 * User: Hongjian
 */
public class CustomerImplementation implements Customer {

    private static final CoffeeDrink DEFAULT_COFFEE = new EspressoCoffee();

    private final CoffeeDrink coffeeDrink;

    public CustomerImplementation() {
        this(DEFAULT_COFFEE);
    }

    public CustomerImplementation(CoffeeDrink coffeeDrink) {
        this.coffeeDrink = coffeeDrink;
    }

    @Override public OrderNumber order(Queue queue) {
        if (queue == null) {
            throw new IllegalArgumentException("The argument of order method cannot be null!");
        }
        try {
            Factory.BINARY_SEMAPHORE.acquire();
            try {
                if (queue.full()) {
                    return null;
                }
                else {
                    return queue.addOrder(coffeeDrink);
                }
            } finally {
                Factory.BINARY_SEMAPHORE.release();
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }

}
