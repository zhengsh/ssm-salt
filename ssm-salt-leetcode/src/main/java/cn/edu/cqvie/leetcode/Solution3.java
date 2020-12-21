package cn.edu.cqvie.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

//3. 无重复字符的最长子串
//    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

//    示例 1:
//
//    输入: s = "abcabcbb"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//    示例 2:
//
//    输入: s = "bbbbb"
//    输出: 1
//    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//    示例 3:
//
//    输入: s = "pwwkew"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//    示例 4:
//
//    输入: s = ""
//    输出: 0
//             
//
//    提示：
//
//            0 <= s.length <= 5 * 104
//    s 由英文字母、数字、符号和空格组成

    public static void main(String[] args) {
        Solution3 solution1 = new Solution3();
        int len = solution1.lengthOfLongestSubstring("dvdf");
        System.out.println(len);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            //特殊判断
            return 0;
        }
        int len = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            //出现了重复
            int idx = sb.toString().indexOf(ch);
            if (idx > -1) {
                //要比原来得长才替换
                len = Math.max(sb.length(), len);
                sb.append(ch);
                sb = new StringBuilder(sb.substring(idx + 1));
            } else {
                sb.append(ch);
            }
        }
        return Math.max(sb.length(), len);
    }
}
