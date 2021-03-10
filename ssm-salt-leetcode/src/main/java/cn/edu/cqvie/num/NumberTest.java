package cn.edu.cqvie.num;

public class NumberTest {


    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        int sum = 0;
        int c = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int n = getValue(s.charAt(i));
            if (c < n) {
                sum -= c;
            } else {
                sum += c;
            }
            c = n;
        }
        sum += c;
        return sum;
    }

    public int getValue(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
