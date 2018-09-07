package me.rivermind.lang.multithread;

/**
 * @author river
 * @date 2016/10/24
 * <p>
 * t1.join() 可以理解成 t1 加入到当前线程中，我要等它执行完
 */
public class JoinTest {
    public static void main(String[] args) {

        Thread t1 = new SubThread(1000);
        Thread t2 = new SubThread(2000);

        try {
            System.out.println("等待2个子线程执行完毕...");
            System.out.println(System.currentTimeMillis());
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("2个子线程已经执行完毕");
            System.out.println(System.currentTimeMillis());
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class SubThread extends Thread {

        private int time;

        SubThread(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(time);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ;
    }
}