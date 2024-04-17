package org.example.ConcurrentCollection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCollection {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 10; j++) {
                    String key = Thread.currentThread().getName() + "-" + j;
                    int value = (int) (Math.random() * 100);
                    map.put(key, value);
                    System.out.println(key + " - " + value);
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        System.out.println("Size of the ConcurrentHashMap: " + map.size());
    }
}
