package cn.edu.cqvie.dp.notify;

public class ThreadA extends Thread {
    private Lock lock;

    public ThreadA(Lock lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin:" + System.currentTimeMillis());
                    lock.wait(10000L);
                    System.out.println("lockCode ==> " + this.lock.lockCode);
                    System.out.println("wait end:" + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
