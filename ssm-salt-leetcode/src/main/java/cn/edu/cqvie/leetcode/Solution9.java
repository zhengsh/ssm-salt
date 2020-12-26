package cn.edu.cqvie.leetcode;

public class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int r = 0;
        while (r < x) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        return r == x || (r / 10 == x);
    }

    public static void main(String[] args) {
        Solution9 solution7 = new Solution9();
        boolean palindrome = solution7.isPalindrome(-123);
        System.out.println(palindrome);
    }
}
