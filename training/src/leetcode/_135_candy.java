package leetcode;

import java.util.Arrays;

public class _135_candy {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                res[i + 1] = res[i] + 1;
            }
            else if (ratings[i] > ratings[i + 1] && res[i] == res[i + 1]) {
                res[i]++;
                int j = i - 1;
                while (j >= 0) {
                    if (ratings[j] > ratings[j + 1] && res[j] == res[j + 1]) {
                        res[j]++;
                        j--;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        int sum = 0;
        for (int re : res) {
            sum += re;
        }
        return sum;
    }

//    二次遍历
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

//    常数空间遍历
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
