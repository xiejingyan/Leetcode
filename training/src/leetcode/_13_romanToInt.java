package leetcode;

public class _13_romanToInt {
    public int romanToInt(String s) {
        int m = 0, c = 0, x = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'M') {
                m++;
            }
            else if (s.charAt(j) == 'D') {
                c += 5;
            }
            else if (s.charAt(j) == 'C') {
                if (j != s.length() - 1 && s.charAt(j + 1) == 'D') {
                    c += 4;
                    j++;
                }
                else if (j != s.length() - 1 && s.charAt(j + 1) == 'M') {
                    c += 9;
                    j++;
                }
                else {
                    c++;
                }
            }
            else if (s.charAt(j) == 'L') {
                x += 5;
            }
            else if (s.charAt(j) == 'X') {
                if (j != s.length() - 1 && s.charAt(j + 1) == 'L') {
                    x += 4;
                    j++;
                }
                else if (j != s.length() - 1 && s.charAt(j + 1) == 'C') {
                    x += 9;
                    j++;
                }
                else {
                    x++;
                }
            }
            else if (s.charAt(j) == 'V') {
                i += 5;
            }
            else {
                if (j != s.length() - 1 && s.charAt(j + 1) == 'V') {
                    i += 4;
                    j++;
                }
                else if (j != s.length() - 1 && s.charAt(j + 1) == 'X') {
                    i += 9;
                    j++;
                }
                else {
                    i++;
                }
            }
        }
        return m * 1000 + c * 100 + x * 10 + i;
    }

//    暂无官方题解
}
