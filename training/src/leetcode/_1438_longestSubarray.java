package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class _1438_longestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        int res = 1, start = 0, min = 0, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[min]) {
                min = i;
                if (nums[max] - nums[min] > limit) {
                    res = Math.max(res, i - start);
                    max++;
                    start = max;
                    min = max;
                    i = max;
                }
            }
            else if (nums[i] >= nums[max]){
                max = i;
                if (nums[max] - nums[min] > limit) {
                    res = Math.max(res, i - start);
                    min++;
                    start = min;
                    max = min;
                    i = min;
                }
            }
        }
        return Math.max(res, nums.length - start);
    }

//    滑动窗口+有序集合
    public int longestSubarray1(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }

//    滑动窗口+单调队列
    public int longestSubarray2(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}
