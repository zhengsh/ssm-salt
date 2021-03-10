package cn.edu.cqvie.str;

// leetcode 14 题
public class StrLongestCommonPrefixTest {

    public static void main(String[] args) {
        StrLongestCommonPrefixTest test = new StrLongestCommonPrefixTest();
        test.longestCommonPrefix(new String[]{"flower", "flow"});
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                if (s.length() == 0 ) {
                    return "";
                }
                s = s.substring(0, s.length() -1);
            }
        }
        return s;
    }
}
