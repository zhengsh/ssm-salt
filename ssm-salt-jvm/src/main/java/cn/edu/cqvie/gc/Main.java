package cn.edu.cqvie.gc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] aArr = new int[]{1, 2, 3, 4};
        int[] bArr = new int[]{2, 3, 4, 5};

        int len = aArr.length + bArr.length;
        int[] rArr = new int[len];
        int l = aArr.length + bArr.length;

        int idx = 0;
        int ib = 0, ia = 0;
        int maxa = aArr[aArr.length - 1], maxb = bArr[bArr.length - 1];
        for (int i = 0; i < l; i++) {
            int a, b;
            if (ia < aArr.length) {
                a = aArr[ia];
            } else {
                a = maxa;
            }
            if (ib < bArr.length) {
                b = bArr[ib];
            } else {
                b = maxb;
            }
            if (a < b) {
                ia++;
                rArr[idx++] = a;
            } else {
                ib++;
                rArr[idx++] = b;
            }
        }

        System.out.println();
        for (int value : rArr) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}