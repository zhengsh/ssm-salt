package cn.edu.cqvie.jvm.oom;

/**
 * -Xss2M
 */
public class JavaVMStackOOM {

    public void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    dontStop();
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }
}
