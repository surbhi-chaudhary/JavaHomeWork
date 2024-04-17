package org.example.WaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private Queue<Integer> queue;
    private int capacity;
    private volatile boolean running;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.running = true;
    }

    public void produce() throws InterruptedException {
        int value = 1;
        while (running) {
            synchronized (this) {
                while (queue.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced: " + value);
                queue.add(value++);
                notifyAll();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (running) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();
                }
                int value = queue.poll();
                System.out.println("Consumer consumed: " + value);
                notifyAll();
                Thread.sleep(500);
            }
        }
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) {
        final ProducerConsumer producerConsumer = new ProducerConsumer(5);

        Thread producerThread = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producerConsumer.stop();
    }

}
