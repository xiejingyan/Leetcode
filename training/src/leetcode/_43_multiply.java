package leetcode;

public class _43_multiply {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        StringBuffer res = new StringBuffer();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tmp = 0, flag = num1.length() - i - 1;
            int a = Integer.parseInt(num1.charAt(i) + "");
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = Integer.parseInt(num2.charAt(j) + "");
                if (flag >= res.length()) {
                    int num = a * b + tmp;
                    tmp = num / 10;
                    num %= 10;
                    res.append(num);
                }
                else {
                    int num = a * b + tmp + Integer.parseInt(res.charAt(flag) + "");
                    tmp = num / 10;
                    num %= 10;
                    res.replace(flag, flag + 1, num + "");
                }
                flag++;
            }
            while (tmp != 0) {
                if (flag >= res.length()) {
                    res.append(tmp);
                    tmp = 0;
                }
                else {
                    tmp += Integer.parseInt(res.charAt(flag) + "");
                    int num = tmp % 10;
                    tmp /= 10;
                    res.replace(flag, flag + 1, num + "");
                }
                flag++;
            }
        }
        return res.reverse().toString();
    }

//    加法
    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }
    public String addStrings(String num1, String num2) {
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
        ans.reverse();
        return ans.toString();
    }

//    乘法
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "456";
        _43_multiply m = new _43_multiply();
        System.out.println(m.multiply(n1, n2));
    }
}
