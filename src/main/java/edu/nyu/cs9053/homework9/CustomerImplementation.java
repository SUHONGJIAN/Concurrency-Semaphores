package edu.nyu.cs9053.homework9;

import java.util.Random;
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
                CoffeeDrink randomCoffee;
                Random random = new Random();
                switch (random.nextInt(3)) {
                    case 0:
                        randomCoffee = new CappuccinoCoffee();
                        break;
                    case 1:
                        randomCoffee = new EspressoCoffee();
                        break;
                    case 2:
                        randomCoffee = new FlatWhiteCoffee();
                        break;
                    default:
                        randomCoffee = coffeeDrink;
                }
                return queue.addOrder(randomCoffee);
            }
        } finally {
            binarySemaphore.release();
        }
    }

}
