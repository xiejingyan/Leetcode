package leetcode;

public class _485_findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            }
            else {
                res = Math.max(res, tmp);
                tmp = 0;
            }
        }
        return Math.max(res, tmp);
    }

//    遍历
    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
