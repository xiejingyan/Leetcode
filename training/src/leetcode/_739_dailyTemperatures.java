package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _739_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                res[i] = 1;
            }
            else {
                int tmp = i + 1;
                while (T[i] >= T[tmp]) {
                    if (res[tmp] == 0) {
                        break;
                    }
                    else {
                        tmp += res[tmp];
                    }
                }
                if (T[i] < T[tmp]) {
                    res[i] = tmp - i;
                }
                else {
                    res[i] = 0;
                }
            }
        }
        return res;
    }

//    暴力
    public int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[T[i]] = i;
        }
        return ans;
    }

//    单调栈
    public int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
