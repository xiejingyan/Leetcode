package leetcode;

public class _674_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1, res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max++;
            }
            else {
                res = Math.max(res, max);
                max = 1;
            }
        }
        res = Math.max(res, max);
        return res;
    }

//    贪心
    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
