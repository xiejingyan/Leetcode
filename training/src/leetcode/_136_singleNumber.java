package leetcode;

public class _136_singleNumber {
    public int singleNumber(int[] nums) {
        sort(nums, 0, nums.length - 1);
        int res = nums[0], i = 1;
        for (; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                res = nums[i - 1];
                break;
            }
        }
        if (i == nums.length) {
            return nums[i - 1];
        }
        return res;
    }
    public void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int t1 = l;
        int t2 = r;
        while (t1 < t2) {
            while (t1 <= t2 && nums[t1] <= nums[l]) {
                t1++;
            }
            while (t2 >= t1 && nums[t2] > nums[l]) {
                t2--;
            }
            int t;
            if (t2 < t1) {
                t = nums[l];
                nums[l] = nums[t2];
            }
            else {
                t = nums[t1];
                nums[t1] = nums[t2];
            }
            nums[t2] = t;
        }
        sort(nums, l, t2 - 1);
        sort(nums, t1, r);
    }

//    位运算
    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
