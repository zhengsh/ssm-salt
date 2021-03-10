package cn.edu.cqvie.str;

public class StrstrTest {

    public static void main(String[] args) {
        StrstrTest test = new StrstrTest();
        int i = test.strStr("abc", "c");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || haystack.equals(needle)) {
            return 0;
        }
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
