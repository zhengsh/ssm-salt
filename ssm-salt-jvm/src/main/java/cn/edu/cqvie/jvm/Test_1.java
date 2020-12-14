package cn.edu.cqvie.jvm;

public class Test_1 {
    public static void main(String[] args) {
        System.out.println(Test_1_B.str);
    }
}

class Test_1_A {
    public static String str = "A str";

    static {
        System.out.println("A Static Block");
    }
}

class Test_1_B extends Test_1_A {
    static {
        System.out.println("B Static Block");
    }
}

//输出结果
//A Static Block
//A str
