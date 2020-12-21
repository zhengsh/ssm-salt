package cn.edu.cqvie.leetcode;

import java.util.Arrays;

public class Solution5 {

// 5. 最长回文子串
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//    示例 1：
//
//    输入: "babad"
//    输出: "bab"
//    注意: "aba" 也是一个有效答案。
//    示例 2：
//
//    输入: "cbbd"
//    输出: "bb"

    public static void main(String[] args) {
        Solution5 solution1 = new Solution5();
        String longestPalindrome = solution1.longestPalindrome("babad");
        System.out.println(longestPalindrome);
    }

    // 回文数
    public String longestPalindrome(String s) {
        if (s.length() < 3) {
            return "";
        }
        String s1 = s.substring(0, 2), s2;
        for (int i = 2; i < s.length(); i++) {
            //回文数判断
            //s1 += s.charAt(i) + "";
        }
        return s1;
    }
}
