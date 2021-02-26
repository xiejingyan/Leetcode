package leetcode;

public class _35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int res = 0, l = 0, r = nums.length - 1;
        while (l <= r) {
            if (target < nums[l]) {
                res = l;
                break;
            }
            else if (target > nums[r]) {
                res = r + 1;
                break;
            }
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;
    }

//    二分查找
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
