package cn.edu.cqvie.leetcode;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        char[] array = new char[s.length()];
        int index = 0;
        int n = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            int x = i;
            while (x < s.length()) {
                array[index] = s.charAt(x);
                index++;

                if (i == 0) {
                    x += n;
                    continue;
                }
                if (i == numRows - 1) {
                    x += n;
                    continue;
                }
                if ((x + i) % n == 0) {
                    x = x + 2 * i;
                    continue;
                }
                x = x + n - 2 * i;
            }
        }
        return String.valueOf(array);
    }


    public static void main(String[] args) {
        Solution6 s6 = new Solution6();
        String convert = s6.convert("1111", 1);
        System.out.println(convert);
    }
}