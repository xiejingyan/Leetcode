package leetcode;

public class _34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && res[0] == -1) {
                res[0] = i;
            }
            else if (nums[i] > target) {
                if (res[0] != -1 && res[1] == -1) {
                    res[1] = i - 1;
                }
                else {
                    break;
                }
            }
            if (nums[i] == target && i == nums.length - 1) {
                res[1] = i;
            }
        }
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
