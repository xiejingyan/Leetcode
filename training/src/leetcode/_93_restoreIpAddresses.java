package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93_restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        search(res, new StringBuffer(), s, 0, 4);
        return res;
    }
    public void search(List<String> res, StringBuffer bf, String s, int n, int num) {
        if (s.length() - n < num) {
            return;
        }
        StringBuffer bff = new StringBuffer(bf);
        if (num == 1) {
            if (s.length() - n == 1 || s.length() - n <= 3 && s.charAt(n) != '0' && Integer.parseInt(s.substring(n)) < 256) {
                bff.append(s.substring(n));
                res.add(bff.toString());
            }
            return;
        }
        for (int i = n; i < Math.min(s.length(), n + 3); i++) {
            if (Integer.parseInt(s.substring(n, i + 1)) < 256) {
                bff.append(s, n, i + 1);
                bff.append('.');
            }
            else {
                return;
            }
            search(res, bff, s, i + 1, num - 1);
            if (i == n && s.charAt(i) == '0') {
                return;
            }
            bff.delete(bff.length() - i + n - 1, bff.length());
        }
    }

//    回溯
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];
    public List<String> restoreIpAddresses1(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }
    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
