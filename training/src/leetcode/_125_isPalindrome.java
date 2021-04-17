package leetcode;

public class _125_isPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int a = s.charAt(l) - '0';
            while (a < 0 || a > 9 && a < 17 || a > 42 && a < 49 || a > 74) {
                l++;
                if (l == s.length()) {
                    break;
                }
                a = s.charAt(l) - '0';
            }
            int b = s.charAt(r) - '0';
            while (b < 0 || b > 9 && b < 17 || b > 42 && b < 49 || b > 74) {
                r--;
                if (r < 0) {
                    break;
                }
                b = s.charAt(r) - '0';
            }
            if (l >= r) {
                break;
            }
            if (a != b) {
                if (a >= 17 && b >= 17 && Math.abs(a - b) == 32) {
                    l++;
                    r--;
                    continue;
                }
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

//    筛选+判断
    public boolean isPalindrome1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

//    筛选+双指针
    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

//    直接判断
    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        _125_isPalindrome ip = new _125_isPalindrome();
        System.out.println(ip.isPalindrome(s));
    }
}
