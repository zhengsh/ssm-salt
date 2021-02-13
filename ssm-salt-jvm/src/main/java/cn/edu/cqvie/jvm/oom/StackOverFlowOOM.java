package cn.edu.cqvie.jvm.oom;

public class StackOverFlowOOM {

    // JVM 设置
    // -Xss128k, -Xss默认1M
    static int count = 0;

    static void redo() {
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
            System.out.println(count);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
