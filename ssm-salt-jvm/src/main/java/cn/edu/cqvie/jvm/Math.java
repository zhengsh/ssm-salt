package cn.edu.cqvie.jvm;

public class Math {

    public int compute() {
        int a = 1026;
        int b = 2018;
        return (a + b) * 10;
    }

    public static void main(String[] args) {
        Math math = new Math();
        //System.out.println(math.compute());
        while (true) {
            math.compute();
        }
    }
}
