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
        if (s == null || s.length() <= 1) {
            return s;
        }

        // 保存起始位置
        int[] range = new int[2];
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(arr, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private int findLongest(char[] arr, int low, int[] range) {
        // 查找中间部分
        int high = low;
        while (high < arr.length - 1 && arr[high + 1] == arr[low]) {
            high++;
        }
        // 定位中间的一个字符
        int ans = high;
        // 中间向两边边拓散
        while (low > 0 && high < arr.length - 1 && arr[low - 1] == arr[high + 1]) {
            low--;
            high++;
        }

        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
