package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {

    private static final Semaphore BINARY_SEMAPHORE = new Semaphore(1);

    public static Customer createCustomer() {
        return new CustomerImplementation(BINARY_SEMAPHORE);
    }

    public static Barista createBarista() {
        return new BaristaImplementation(BINARY_SEMAPHORE);
    }

}
