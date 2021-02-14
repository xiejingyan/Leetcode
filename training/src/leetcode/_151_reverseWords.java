package leetcode;

import java.util.*;

public class _151_reverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        int f = -1;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ' ' && f != -1) {
                String substring = sb.substring(i + 1, f + 1);
                res.append(substring).append(' ');
                f = -1;
            }
            if (sb.charAt(i) != ' ' && f == -1) {
                f = i;
            }
        }
        if (f != -1) {
            String substring = sb.substring(0, f + 1);
            res.append(substring);
        }
        if (res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

//    正则表达式
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

//    双端队列
    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        _151_reverseWords rw = new _151_reverseWords();
        System.out.println(rw.reverseWords(s));
    }
}
