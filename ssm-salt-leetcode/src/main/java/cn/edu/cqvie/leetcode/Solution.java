package cn.edu.cqvie.leetcode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String atbsst = solution.removeDuplicateLetters("cbacdcbc");
        System.out.println(atbsst);
    }

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder(26);
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char a = s.charAt(i);
            //1.如果不存在
            String s1 = sb.toString();
            if (s1.indexOf(String.valueOf(a)) == -1) {
                char e = sb.charAt(sb.capacity() - 1);
                if (a > e) {
                    sb.append(a);
                    continue;
                }
                if (a < e) {
                    sb = new StringBuilder(26);
                    continue;
                }
            }

        }
        return sb.toString();
    }
}