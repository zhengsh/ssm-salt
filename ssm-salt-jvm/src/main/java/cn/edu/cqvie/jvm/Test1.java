package cn.edu.cqvie.jvm;

public class Test1 {

    private static String strA = "strA";


    public static void main(String[] args) {
        int[] arr = new int[5];
        Object[] arr2 = new Object[5];

        System.out.println(strA);
        System.out.println(arr);

        System.out.println(arr2);
    }
}