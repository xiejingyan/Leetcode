package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _738_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N - 1;
        }
        String n = N + "";
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < n.length(); i++) {
            num.add(n.charAt(i) - '0');
        }
        for (int i = num.size() - 1; i > 0; i--) {
            if (num.get(i) < num.get(i - 1)) {
                num.set(i - 1, num.get(i - 1) - 1);
                for (int j = i; j < num.size(); j++) {
                    if (num.get(j) == 9) {
                        break;
                    }
                    num.set(j, 9);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < num.size(); i++) {
            res += num.get(i) * Math.pow(10, num.size() - 1 - i);
        }
        return res;
    }

    public int monotoneIncreasingDigits1(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static void main(String[] args) {
        _738_monotoneIncreasingDigits mid = new _738_monotoneIncreasingDigits();
        System.out.println(mid.monotoneIncreasingDigits(10));
    }
}
