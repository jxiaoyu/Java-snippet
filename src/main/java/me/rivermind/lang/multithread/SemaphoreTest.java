package me.rivermind.lang.multithread;

import java.util.concurrent.Semaphore;

/**
 * @author river
 * @date 2016/10/24
 * <p>
 * Semaphore 主要的方法是 acquire() 和 release()
 * 跟 ReentrantLock 很像 也有 tryAcquire 的非阻塞方法
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) { new Worker(i, semaphore).start(); }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}