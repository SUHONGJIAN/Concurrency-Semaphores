package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: Hongjian
 */
public final class CustomerImplementation implements Customer {

    private static final CoffeeDrink DEFAULT_COFFEE = new EspressoCoffee();

    private final CoffeeDrink coffeeDrink;

    private final Semaphore binarySemaphore;

    CustomerImplementation(Semaphore binarySemaphore) {
        this(DEFAULT_COFFEE, binarySemaphore);
    }

    CustomerImplementation(CoffeeDrink coffeeDrink, Semaphore binarySemaphore) {
        this.coffeeDrink = coffeeDrink;
        this.binarySemaphore = binarySemaphore;
    }

    @Override public OrderNumber order(Queue queue) {
        if (queue == null) {
            throw new IllegalArgumentException("The argument of order method cannot be null!");
        }
        try {
            binarySemaphore.acquire();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        try {
            if (queue.full()) {
                return null;
            }
            else {
                return queue.addOrder(coffeeDrink);
            }
        } finally {
            binarySemaphore.release();
        }
    }

}
