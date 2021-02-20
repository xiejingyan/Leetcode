package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _697_findShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        int[][] tmp = new int[50000][3];
        int res = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp[nums[i]][0] == 0) {
                tmp[nums[i]][0] = 1;
                tmp[nums[i]][1] = i;
            }
            else {
                tmp[nums[i]][0]++;
            }
            tmp[nums[i]][2] = i;
        }
        for (int[] ints : tmp) {
            if (ints[0] > max) {
                res = ints[2] - ints[1] + 1;
                max = ints[0];
            } else if (ints[0] != 0 && ints[0] == max) {
                res = Math.min(res, ints[2] - ints[1] + 1);
            }
        }
        return res;
    }

//    哈希表
    public int findShortestSubArray1(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        _697_findShortestSubArray fssa = new _697_findShortestSubArray();
        System.out.println(fssa.findShortestSubArray(nums));
    }
}
