package leetcode;

public class _12_intToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int n = num / 1000;
        res.append("M".repeat(n));
        num %= 1000;
        n = num / 100;
        if (n == 9) {
            res.append("CM");
        }
        else if (n > 4) {
            res.append("D").append("C".repeat(n - 5));
        }
        else if (n == 4) {
            res.append("CD");
        }
        else {
            res.append("C".repeat(n));
        }
        num %= 100;
        n = num / 10;
        if (n == 9) {
            res.append("XC");
        }
        else if (n > 4) {
            res.append("L").append("X".repeat(n - 5));
        }
        else if (n == 4) {
            res.append("XL");
        }
        else {
            res.append("X".repeat(n));
        }
        num %= 10;
        n = num;
        if (n == 9) {
            res.append("IX");
        }
        else if (n > 4) {
            res.append("V").append("I".repeat(n - 5));
        }
        else if (n == 4) {
            res.append("IV");
        }
        else {
            res.append("I".repeat(n));
        }
        return res.toString();
    }

//    贪心
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman1(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

//    硬编码数字
    public String intToRoman2(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
}
