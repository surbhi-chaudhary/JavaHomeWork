package org.example.Synchronization;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account(5000);
        Account acc2 = new Account(8000);

        System.out.println("Intial Balance of account 1: " + acc1.getBalance());
        System.out.println("Intial Balance of account 2: " + acc2.getBalance());

        Thread thread1 = new Thread(() -> acc1.transfer(acc2, 500));
        Thread thread2 = new Thread(() -> acc2.transfer(acc1, 2000));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance of account 1: " + acc1.getBalance());
        System.out.println("Final Balance of account 2: " + acc2.getBalance());
    }
}
