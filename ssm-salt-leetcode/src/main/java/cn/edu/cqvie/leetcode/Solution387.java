package cn.edu.cqvie.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution387 {

//    387. 字符串中的第一个唯一字符
//    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//    示例：
//
//    s = "leetcode"
//    返回 0
//
//    s = "loveleetcode"
//    返回 2
//             
//
//    提示：你可以假定该字符串只包含小写字母。

    public static void main(String[] args) {
        Solution387 solution1 = new Solution387();
        int idx = solution1.firstUniqChar("cc");
        System.out.println("idx = " + idx);
    }

    public int firstUniqChar(String s) {
        //上次重复出现的字符
        char[] arrays = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char c1 = s.charAt(i);
            boolean b = true;
            for (char a : arrays) {
                if (c1 == a) {
                    b = false;
                    break;
                }
            }
            //已经出现过
            for (int j = i + 1; j < s.length() && b; j++) {
                if (c1 == s.charAt(j)) {
                    arrays[i] = c1;
                    b = false;
                    break;
                }
            }
            if (b) {
                return i;
            }
        }
        return -1;
    }
}
