package me.rivermind.lang.multithread.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jxiao
 * @date 2016/10/13
 * <p>
 * 用 synchronized 实现的简单阻塞队列
 */

public class BlockingQueue0<T> {

    private List<T> queue = new LinkedList<T>();

    private int capacity;

    public BlockingQueue0(int capacity) {
        this.capacity = capacity;
    }

    public void put(T t) {
        synchronized (this) {
            while (getSize() >= capacity) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
            if (getSize() == 0) {
                this.notifyAll();
            }
            queue.add(t);
        }
    }

    public T take() {
        synchronized (this) {
            while (getSize() == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
            if (getSize() == capacity) {
                this.notifyAll();
            }
            return queue.remove(0);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return queue.size();
    }

    public static void main(String[] args) {
        BlockingQueue0<Integer> pq = new BlockingQueue0<>(1);

        Thread t1 = new Thread(() -> {
            pq.put(1);
            System.out.println("put");
        });

        Thread t2 = new Thread(() -> {
            pq.take();
            System.out.println("take");
        });

        Thread t3 = new Thread(() -> {
            pq.put(2);
            System.out.println("put");
        });

        t1.start();
        t3.start();
        t2.start();
    }
}
