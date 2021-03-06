package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _496_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int k : nums2) {
                if (nums1[i] == k) {
                    flag = true;
                }
                if (flag && k > nums1[i]) {
                    res[i] = k;
                    break;
                }
            }
        }
        return res;
    }

//    单调栈
    public int[] nextGreaterElement1(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}
