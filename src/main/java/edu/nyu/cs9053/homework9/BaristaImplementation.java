package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: Hongjian
 */
public final class BaristaImplementation implements Barista {

    private final Semaphore binarySemaphore;

    BaristaImplementation(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
    }

    @Override public OrderNumber handle(Queue from) {
        if (from == null) {
            throw new IllegalArgumentException("The argument of handle method cannot be null!");
        }
        try {
            binarySemaphore.acquire();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        try {
            if (from.isEmpty()) {
                return null;
            }
            else {
                return from.getOrderNumber();
            }
        } finally {
            binarySemaphore.release();
        }
    }

}
