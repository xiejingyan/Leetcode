package leetcode;

public class _9_isPalindrome {
    public boolean isPalindrome(int x) {
        StringBuilder res = new StringBuilder(String.valueOf(x));
        for (int i = 0; i < res.length(); i++) {
            if (res.length() - 1 - i <= i) {
                break;
            }
            if (res.charAt(i) != res.charAt(res.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

//    反转一半数字
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        _9_isPalindrome ip = new _9_isPalindrome();
        System.out.println(ip.isPalindrome(10));
    }
}
