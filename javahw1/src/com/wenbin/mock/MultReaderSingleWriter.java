package com.wenbin.mock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultReaderSingleWriter<K, V> {
    Map<K, V> map = null;
    public MultReaderSingleWriter(Map<K, V> map) {
        this.map = map;
    }

    public MultReaderSingleWriter() {
        this.map = new HashMap<K, V>();
    }

    Lock lock = new ReentrantLock(true);

    public void set(K k, V v) {
        if (map == null) return;
        try {
            lock.tryLock();
            map.put(k, v);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public V get(K k) {
        return map.get(k);
    }

    public static void main(String[] args) {
        MultReaderSingleWriter<Integer, String> map = new MultReaderSingleWriter();

        ExecutorService exe = Executors.newFixedThreadPool(3);
        Random random = new Random();
        exe.submit(() -> {
           while(true) {
               int num = random.nextInt(100);
               String str = num + "_String";
               map.set(num, str);
               Thread.sleep(1000);
           }
        });

        exe.submit(() -> {
            while(true) {
                int numII = random.nextInt(100);
                String strII = numII + "_String";
                map.set(numII, strII);
                Thread.sleep(1000);
            }
        });

        exe.submit(() -> {
            while (true) {
                int num = random.nextInt(100);
                System.out.println(map.get(num));
                Thread.sleep(1000);
            }
        });
    }

}
