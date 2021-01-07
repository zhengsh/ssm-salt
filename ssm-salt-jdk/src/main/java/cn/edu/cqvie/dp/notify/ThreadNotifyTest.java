package cn.edu.cqvie.dp.notify;

import java.util.ArrayList;
import java.util.List;

public class ThreadNotifyTest {

    public static void main(String[] args) {
        try {
            Lock lock = new Lock();

            ThreadA a = new ThreadA(lock);
            a.start();

            ThreadA b = new ThreadA(lock);
            b.start();

            ThreadA c = new ThreadA(lock);
            c.start();

            Thread.sleep(1000);

            ThreadB d = new ThreadB(lock);
            d.start();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}

class MyList {
    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("test");
    }

    public static int size() {
        return list.size();
    }
}


