package me.rivermind.thread.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jxiao
 * @date 2016/10/13
 * <p>
 * 用 ReentrantLock 以及 Condition 实现的简单阻塞队列
 */
public class BlockingQueue<T> {

    private List<T> queue = new LinkedList<T>();

    private int capacity;

    private Lock lock = new ReentrantLock();

    private Condition empty = lock.newCondition();

    private Condition full = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(T t) {
        lock.lock();
        try {
            while (getSize() >= capacity) {
                try {
                    full.await();
                } catch (InterruptedException e) {
                }
            }
            if (getSize() == 0) {
                empty.signalAll();
            }
            queue.add(t);
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (getSize() == 0) {
                try {
                    empty.wait();
                } catch (InterruptedException e) {
                }
            }
            if (getSize() == capacity) {
                full.signalAll();
            }
            return queue.remove(0);
        } finally {
            lock.unlock();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return queue.size();
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> pq = new BlockingQueue<>(1);

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
