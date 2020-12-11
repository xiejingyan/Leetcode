package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _649_predictPartyVictory {
    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);
        int r = 0, d = 0, num = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r++;
            }
            else {
                d++;
            }
        }
        while (true) {
            if (r == 0) {
                return "Dire";
            }
            if (d == 0) {
                return "Radiant";
            }
            if (sb.charAt(num) == 'R') {
                for (int i = num + 1; i != num; i++) {
                    if (i == sb.length()) {
                        i = -1;
                    }
                    else {
                        if (sb.charAt(i) == 'D') {
                            sb.deleteCharAt(i);
                            d--;
                            num++;
                            if (num >= sb.length()) {
                                num = 0;
                            }
                            break;
                        }
                    }
                }
            }
            else {
                for (int i = num + 1; i != num; i++) {
                    if (i == sb.length()) {
                        i = -1;
                    }
                    else {
                        if (sb.charAt(i) == 'R') {
                            sb.deleteCharAt(i);
                            r--;
                            num++;
                            if (num >= sb.length()) {
                                num = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public String predictPartyVictory1(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        String senate = "DDRRR";
        _649_predictPartyVictory ppv = new _649_predictPartyVictory();
        String s = ppv.predictPartyVictory(senate);
        System.out.println(s);
    }
}
