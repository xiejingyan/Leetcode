package leetcode;

import java.util.*;

public class _1122_relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> num = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        List<Integer> ar = new ArrayList<>();
        for (int i : arr2) {
            ar.add(i);
        }
        for (int i : arr1) {
            if (!ar.contains(i)) arr.add(i);
            else {
                if (num.containsKey(i)) {
                    int tmp = num.get(i);
                    num.put(i, ++tmp);
                }
                else {
                    num.put(i, 1);
                }
            }
        }
        int[] res = new int[arr1.length];
        int j = 0;
        for (int i : arr2) {
            for (int n = 0; n < num.get(i); j++, n++) {
                res[j] = i;
            }
        }
        int flag = j;
        for (Integer integer : arr) {
            res[j] = integer;
            j++;
        }
        Arrays.sort(res, flag, res.length);
        return res;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
