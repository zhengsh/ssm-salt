package cn.edu.cqvie.jvm;

public class Test1 {

    private static final int a = 1000;
    private static int  b = 100;

    public static void main(String[] args) {
        int[] arr = new int[5];
        Object[] arr2 = new Object[5];

        System.out.println(arr);
        System.out.println(arr2);

        System.out.println(a);
        System.out.println(b);
//        Test1 test1 = new Test1();
//        System.out.println(test1.a);
//        System.out.println(test1.b);
    }
}
