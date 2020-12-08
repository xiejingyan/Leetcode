package leetcode;

public class _283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (;i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                while (nums[j] == 0) {
                    if (j == nums.length - 1){
                        break;
                    }
                    j++;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
