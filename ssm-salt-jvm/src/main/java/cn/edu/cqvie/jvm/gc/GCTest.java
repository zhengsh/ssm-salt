package cn.edu.cqvie.jvm.gc;

/**
 * -XX:+PrintGCDetails
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allcation2 = new byte[8000 * 1024];
    }
}
