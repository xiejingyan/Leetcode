package leetcode;

public class _offer21_exchange {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                r--;
            }
            else {
                l++;
            }
        }
        return nums;
    }
}
