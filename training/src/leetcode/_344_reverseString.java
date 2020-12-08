package leetcode;

public class _344_reverseString {
    public static void reverseString(char[] s) {
        int a = 0;
        int b = s.length - 1;
        char tmp;
        while (a < b) {
            tmp = s[a];
            s[a] = s[b];
            s[b] = tmp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }
    }
}
