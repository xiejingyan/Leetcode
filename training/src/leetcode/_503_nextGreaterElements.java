package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _503_nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!index.isEmpty() && nums[i] > nums[index.peekLast()]) {
                res[index.pollLast()] = nums[i];
            }
            index.addLast(i);
        }
        for (int num : nums) {
            while (!index.isEmpty() && num > nums[index.peekLast()]) {
                res[index.pollLast()] = num;
            }
        }
        while (!index.isEmpty()) {
            res[index.pollLast()] = -1;
        }
        return res;
    }

//    单调栈+循环数组
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
