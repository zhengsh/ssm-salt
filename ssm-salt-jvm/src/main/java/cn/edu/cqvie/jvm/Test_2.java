package cn.edu.cqvie.jvm;

public class Test_2 extends Test_2_A {
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public Test_2() {
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        new Test_2();
    }

}

class Test_2_A {

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public Test_2_A() {
        System.out.println("父类构造方法");
    }

    public static void find() {
        System.out.println("静态方法");
    }
}

//代码块和构造方法执行顺序
//1).父类静态代码块
//2).子类静态代码块
//3).父类代码块
//4).父类构造方法
//5).子类代码块
//6).子类构造方法
