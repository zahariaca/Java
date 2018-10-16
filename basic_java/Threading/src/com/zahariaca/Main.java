package com.zahariaca;

public class Main {

    public static void main(String[] args) {
        SharedResources sharedResources = new SharedResources("Shared resourceOne", "Shared resourceTwo");

        Thread threadOne = new Thread(new ThreadOne(sharedResources));
        Thread threadTwo = new Thread(new ThreadTwo(sharedResources));

        threadOne.start();
        threadTwo.start();


    }


}

class ThreadOne implements Runnable {
    SharedResources sharedResources;

    public ThreadOne(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
    }

    @Override
    public void run() {
        synchronized (sharedResources.resourceOne) {
            System.out.println("Acquired Lock on resourceOne by: " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }

            System.out.println("Waiting to acquire the lock on resourceTwo by: " + Thread.currentThread().getName());
            synchronized (sharedResources.resourceTwo) {
                System.out.println("Acquired lock on resourceTwo");
            }
        }
    }
}

class ThreadTwo implements Runnable {
    SharedResources sharedResources;

    public ThreadTwo(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
    }

    @Override
    public void run() {
        synchronized (sharedResources.resourceTwo) {
            System.out.println("Acquired Lock on resourceTwo by: " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }

            System.out.println("Waiting to acquire the lock on resourceOne by: " + Thread.currentThread().getName());
            synchronized (sharedResources.resourceOne) {
                System.out.println("Acquired lock on resourceOne");
            }
        }
    }
}

class SharedResources {
    String resourceOne = null;
    String resourceTwo = null;

    public SharedResources(String resourceOne, String resourceTwo) {
        this.resourceOne = resourceOne;
        this.resourceTwo = resourceTwo;
    }
}
