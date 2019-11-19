package edu.nyu.cs9053.homework9;

/**
 * User: Hongjian
 */
public class BaristaImplementation implements Barista {

    @Override public OrderNumber handle(Queue from) {
        if (from == null) {
            throw new IllegalArgumentException("The argument of handle method cannot be null!");
        }
        try {
            Factory.BINARY_SEMAPHORE.acquire();
            try {
                if (from.isEmpty()) {
                    return null;
                }
                else {
                    return from.getOrderNumber();
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
