package cn.edu.cqvie.leetcode;

import sun.java2d.pipe.SpanClipRenderer;

public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution7 = new Solution8();
        int atoi = solution7.myAtoi("    -43");
        System.out.println(atoi);
        System.out.println((int) '+');
    }

    public int myAtoi(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int status = 1;

        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '-') {
                status = -1;
                continue;
            }
            if (i == 0 && c == '+') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
                if (i > 8) {
                    long res = Long.parseLong(sb.toString());
                    res = res * status;
                    if (res > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (res < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
                continue;
            }
            break;
        }
        if ("".equals(sb.toString())) {
            return 0;
        }
        long res = Long.parseLong(sb.toString());
        res = res * status;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
