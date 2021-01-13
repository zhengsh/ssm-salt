package cn.edu.cqvie.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ThreadInterruptTest {


    static class T extends Thread {
        private int i;

        @Override
        public synchronized void run() {
            while (true) {
                i++;
                System.out.println(i);

                try {
                    // wait 可以感知到线程中断抛出, 会清除中断标志位
                    // java.lang.InterruptedException
                    // wait(1000);

                    // sleep 可以感知到线程中断, 会清除中断标志位
                    // TimeUnit.SECONDS.sleep(1);

                    //LockSupport.park() 可以中断，但是不能清除中断标志位
                    LockSupport.park();

                } catch (Throwable e) {
                    e.printStackTrace();
                }


                // Thread.interrupted() 会清除线程的中断标志位
                // Thread.currentThread().isInterrupted() 不会清除线程的中断标志位
                if (Thread.interrupted()) {
                    System.out.println("========");
                    //break;
                }


                if (i > 10) {
                    System.out.println("i > 10");
                    break;
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();
        TimeUnit.SECONDS.sleep(3L);
        t1.interrupt();
        TimeUnit.SECONDS.sleep(3L);
        LockSupport.unpark(t1);
    }
}
