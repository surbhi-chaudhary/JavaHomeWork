package org.example.LocksReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void incrementAndPrint() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + ": Count = " + count);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ThreadSafeCounter counter = new ThreadSafeCounter();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    counter.incrementAndPrint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
