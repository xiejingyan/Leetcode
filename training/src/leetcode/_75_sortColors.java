package leetcode;

public class _75_sortColors {
    public static void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num == 0) a++;
            else if (num == 1) b++;
        }
        b += a;

        for (int i = 0; i < nums.length; i++) {
            if (i < a) nums[i] = 0;
            else if (i >= a && i < b) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void sortColors2(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[a];
                nums[a] = 0;
                a++;
            }
        }
        for (int i = nums.length - 1; i >= a; i--) {
            if (nums[i] == 2) {
                nums[i] = nums[b];
                nums[b] = 2;
                b--;
            }
        }
    }
}
