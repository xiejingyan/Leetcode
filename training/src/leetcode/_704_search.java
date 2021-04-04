package leetcode;

public class _704_search {
    public int search(int[] nums, int target) {
        return midSearch(nums, 0, nums.length - 1, target);
    }
    public int midSearch(int[] nums, int f, int e, int target) {
        if (f > e) {
            return -1;
        }
        int mid = (f + e) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] > target) {
            return midSearch(nums, f, mid - 1, target);
        }
        else {
            return midSearch(nums, mid + 1, e, target);
        }
    }

//    二分查找
    public int search1(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }
}
