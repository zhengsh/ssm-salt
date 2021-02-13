package cn.edu.cqvie.loader;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);

        BigDecimal y = b.subtract(c);

        if (x.equals(y)) {
            System.out.println("true");
        }

        if (a.compareTo(b.add(c)) != 0) {
            System.out.println("true");
        }
    }
}
