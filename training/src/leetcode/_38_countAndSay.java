package leetcode;

public class _38_countAndSay {
    public String countAndSay(int n) {
        if (n > 1) {
            String s = countAndSay(n - 1);
            StringBuilder res = new StringBuilder();
            int num = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    num++;
                }
                else {
                    res.append(num);
                    res.append(s.charAt(i));
                    num = 1;
                }
            }
            res.append(num);
            res.append(s.charAt(s.length() - 1));
            return res.toString();
        }
        else {
            return "1";
        }
    }

    public static void main(String[] args) {
        _38_countAndSay cas = new _38_countAndSay();
        System.out.println(cas.countAndSay(2));
    }
}
