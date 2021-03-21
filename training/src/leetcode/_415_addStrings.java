package leetcode;

public class _415_addStrings {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int flag = 0;
        while (length1 >= 0 || length2 >= 0) {
            int a = 0, b = 0;
            if (length1 < 0) {
                b = num2.charAt(length2) - '0';
            }
            else if (length2 < 0) {
                a = num1.charAt(length1) - '0';
            }
            else {
                a = num1.charAt(length1) - '0';
                b = num2.charAt(length2) - '0';
            }
            if (a + b + flag > 9) {
                res.insert(0, a + b + flag - 10);
                flag = 1;
            }
            else {
                res.insert(0, a + b + flag);
                flag = 0;
            }
            length1--;
            length2--;
        }
        if (flag == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }

//    模拟
    public String addStrings1(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String n1 = "1110";
        String n2 = "22230";
        _415_addStrings as = new _415_addStrings();
        System.out.println(as.addStrings(n1, n2));
    }
}
