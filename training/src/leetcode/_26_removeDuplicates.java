package leetcode;

public class _26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int res = nums.length, tmp = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res--;
                if (tmp == -1) {
                    tmp = i;
                }
            }
            else {
                if (tmp != -1) {
                    nums[tmp] = nums[i];
                    tmp++;
                }
            }
        }
        return res;
    }

//    双指针
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
