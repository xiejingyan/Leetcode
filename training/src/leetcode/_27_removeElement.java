package leetcode;

public class _27_removeElement {
    public int removeElement(int[] nums, int val) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[tmp] = nums[i];
                tmp++;
            }
        }
        return tmp;
    }

//    双指针
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

//    双指针+改变顺序
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
