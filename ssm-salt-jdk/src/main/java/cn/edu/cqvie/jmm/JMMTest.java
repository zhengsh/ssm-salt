package cn.edu.cqvie.jmm;

public class JMMTest {

    static boolean flag = true;
    static int count = 0;

    static class T extends Thread {
        @Override
        public void run() {
            if (flag) {
                flag = false;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            T t = new T();
            t.start();
        }
    }
}
