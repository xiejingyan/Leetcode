package leetcode;

import java.util.Arrays;

public class _31_nextPermutation {
    public void nextPermutation(int[] nums) {
        boolean tmp = false;
        int i, j, t;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                tmp = true;
                break;
            }
        }
        if (!tmp) Arrays.sort(nums);
        else {
            for (j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1] && nums[j] != nums[j - 1]) {
                    break;
                }
            }
            t = nums[j];
            nums[j] = nums[i - 1];
            nums[i - 1] = t;
            Arrays.sort(nums, i, nums.length);
        }
    }

    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
