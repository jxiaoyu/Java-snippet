package me.rivermind.lang.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author river
 * @date 2016/10/24
 * <p>
 * CountDownLatch 最重要的两个方法是 await() 和 countDown()
 * 这个类的作用跟 Thread.join() 方法很像，可以跟 JoinTest.java 对比下
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new SubThread(latch).start();
        new SubThread(latch).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class SubThread extends Thread {

        private CountDownLatch latch;

        SubThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}