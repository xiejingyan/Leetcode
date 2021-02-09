package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _992_subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            List<Integer> num = new ArrayList<>();
            for (int j = i; j < A.length; j++) {
                if (!num.contains(A[j])) {
                    num.add(A[j]);
                }
                if (num.size() == K) {
                    res++;
                }
                else if (num.size() > K) {
                    break;
                }
            }
            if (A.length - i < K) {
                break;
            }
        }
        return res;
    }

//    滑动窗口
    public int subarraysWithKDistinct1(int[] A, int K) {
        int n = A.length;
        int[] num1 = new int[n + 1];
        int[] num2 = new int[n + 1];
        int tot1 = 0, tot2 = 0;
        int left1 = 0, left2 = 0, right = 0;
        int ret = 0;
        while (right < n) {
            if (num1[A[right]] == 0) {
                tot1++;
            }
            num1[A[right]]++;
            if (num2[A[right]] == 0) {
                tot2++;
            }
            num2[A[right]]++;
            while (tot1 > K) {
                num1[A[left1]]--;
                if (num1[A[left1]] == 0) {
                    tot1--;
                }
                left1++;
            }
            while (tot2 > K - 1) {
                num2[A[left2]]--;
                if (num2[A[left2]] == 0) {
                    tot2--;
                }
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {
        _992_subarraysWithKDistinct swkd = new _992_subarraysWithKDistinct();
        int[] A = {1, 2, 1, 2, 3};
        System.out.println(swkd.subarraysWithKDistinct1(A, 2));
    }
}
