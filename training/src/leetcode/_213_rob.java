package leetcode;

public class _213_rob {
    public int rob(int[] nums) {
        int res = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][1] = -nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp1 = 0, tmp2 = 0;
            for (int j = 0; j < i - 1; j++) {
                tmp1 = Math.max(tmp1, dp[j][0]);
                tmp2 = Math.min(tmp2, dp[j][1]);
            }
            dp[i][0] = nums[i] + tmp1;
            dp[i][1] = -nums[i] + tmp2;
            if (i == nums.length - 1) {
                res = Math.max(res, dp[i][0]);
            }
            else {
                res = Math.max(res, Math.max(dp[i][0], -dp[i][1]));
            }
        }
        return res;
    }

//    动态规划
    public int rob1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }
    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
