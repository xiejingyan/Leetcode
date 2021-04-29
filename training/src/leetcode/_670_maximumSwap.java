package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _670_maximumSwap {
    public int maximumSwap(int num) {
        int res = num;
        List<Integer> list = new ArrayList<>();
        while (res != 0) {
            list.add(res % 10);
            res /= 10;
        }
        int tmp = -1, f = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                if (tmp == -1) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (!list.get(j).equals(list.get(i - 1))) {
                            tmp = j + 1;
                            break;
                        }
                    }
                    if (tmp == -1) {
                        tmp = 0;
                    }
                }
                else {
                    if (list.get(tmp) < list.get(i - 1)) {
                        for (int j = i - 1; j >= tmp; j--) {
                            if (!list.get(j).equals(list.get(i - 1))) {
                                tmp = j + 1;
                                break;
                            }
                        }
                    }
                }
            }
            if (tmp != -1 && list.get(i) < list.get(tmp)) {
                f = i;
            }
        }
        if (tmp != -1) {
            int a = 1, b = 1;
            for (int i = 0; i < tmp; i++) {
                a *= 10;
            }
            for (int i = 0; i < f; i++) {
                b *= 10;
            }
            num -= list.get(tmp) * a;
            num -= list.get(f) * b;
            num += list.get(tmp) * b;
            num += list.get(f) * a;
        }
        return num;
    }

//    暴力
    public int maximumSwap1(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();
        int max = num;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(charArray, i, j);
                max = Math.max(max, Integer.parseInt(new String(charArray)));
                swap(charArray, i, j);
            }
        }
        return max;
    }
    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }

//    贪心
    public int maximumSwap2(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 记录每个数字出现的最后一次出现的下标
        int[] last = new int[10];
        for (int i = 0; i < len; i++) {
            last[charArray[i] - '0'] = i;
        }

        // 从左向右扫描，找到当前位置右边的最大的数字并交换
        for (int i = 0; i < len - 1; i++) {
            // 找最大，所以倒着找
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(charArray, i, last[d]);
                    // 只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }
//    private void swap(char[] charArray, int index1, int index2) {
//        char temp = charArray[index1];
//        charArray[index1] = charArray[index2];
//        charArray[index2] = temp;
//    }
}
