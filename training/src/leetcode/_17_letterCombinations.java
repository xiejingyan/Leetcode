package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            if (res.size() == 0) {
                if (digits.charAt(i) == '2') {
                    res.add("a");
                    res.add("b");
                    res.add("c");
                }
                else if (digits.charAt(i) == '3') {
                    res.add("d");
                    res.add("e");
                    res.add("f");
                }
                else if (digits.charAt(i) == '4') {
                    res.add("g");
                    res.add("h");
                    res.add("i");
                }
                else if (digits.charAt(i) == '5') {
                    res.add("j");
                    res.add("k");
                    res.add("l");
                }
                else if (digits.charAt(i) == '6') {
                    res.add("m");
                    res.add("n");
                    res.add("o");
                }
                else if (digits.charAt(i) == '7') {
                    res.add("p");
                    res.add("q");
                    res.add("r");
                    res.add("s");
                }
                else if (digits.charAt(i) == '8') {
                    res.add("t");
                    res.add("u");
                    res.add("v");
                }
                else {
                    res.add("w");
                    res.add("x");
                    res.add("y");
                    res.add("z");
                }
            }
            else {
                List<String> tmp = new ArrayList<>(res);
                res.clear();
                for (String s : tmp) {
                    if (digits.charAt(i) == '2') {
                        res.add(s + "a");
                        res.add(s + "b");
                        res.add(s + "c");
                    }
                    else if (digits.charAt(i) == '3') {
                        res.add(s + "d");
                        res.add(s + "e");
                        res.add(s + "f");
                    }
                    else if (digits.charAt(i) == '4') {
                        res.add(s + "g");
                        res.add(s + "h");
                        res.add(s + "i");
                    }
                    else if (digits.charAt(i) == '5') {
                        res.add(s + "j");
                        res.add(s + "k");
                        res.add(s + "l");
                    }
                    else if (digits.charAt(i) == '6') {
                        res.add(s + "m");
                        res.add(s + "n");
                        res.add(s + "o");
                    }
                    else if (digits.charAt(i) == '7') {
                        res.add(s + "p");
                        res.add(s + "q");
                        res.add(s + "r");
                        res.add(s + "s");
                    }
                    else if (digits.charAt(i) == '8') {
                        res.add(s + "t");
                        res.add(s + "u");
                        res.add(s + "v");
                    }
                    else {
                        res.add(s + "w");
                        res.add(s + "x");
                        res.add(s + "y");
                        res.add(s + "z");
                    }
                }
            }
        }
        return res;
    }

//    回溯
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
