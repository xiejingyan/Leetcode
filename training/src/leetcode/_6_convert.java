package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _6_convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int tmp = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += tmp) {
                    res.insert(res.length(), s.charAt(j));
                }
            }
            else {
                boolean flag = true;
                for (int j = i; j < s.length();) {
                    res.insert(res.length(), s.charAt(j));
                    if (flag) {
                        j += tmp - i * 2;
                        flag = false;
                    }
                    else {
                        j += i * 2;
                        flag = true;
                    }
                }
            }
        }
        return res.toString();
    }

//    按行排序
    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

//    按行访问
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        _6_convert c = new _6_convert();
        System.out.println(c.convert("A", 1));
    }
}
