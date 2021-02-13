package com.test;

public class TestB {

    public static void main(String[] args) {
        String a = "547";
        String b = "3867222";
        int l1 = a.length();
        int l2 = b.length();
        int count = Math.max(l1, l2);
        boolean flag = false;
        String result = "";
        for (int i = 0; i < count; i++) {
            int idxa = l1 - 1 - i;
            int idxb = l2 - 1 - i;
            int r = 0;
            if (idxa < l1 && idxa >= 0) {
                r += Integer.parseInt(String.valueOf(a.charAt(idxa)));
            }
            if (idxb < l2 && idxb >= 0) {
                r += Integer.parseInt(String.valueOf(b.charAt(idxb)));
            }
            if (flag) {
                r++;
            }
            if (r > 9) {
                flag = true;
                r = 9;
            } else {
                flag = false;
            }
            result = r + result;
        }

        System.out.println(result);
    }
}
