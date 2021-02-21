package leetcode;

import java.util.Arrays;

public class _45_jump {
    public int jump(int[] nums) {
        int[] js = new int[nums.length];
        Arrays.fill(js, Integer.MAX_VALUE);
        js[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < js.length; j++) {
                js[i + j] = Math.min(js[i + j], js[i] + 1);
                if (i + j == js.length - 1) {
                    return js[js.length - 1];
                }
            }
        }
        return js[js.length - 1];
    }

//    反向查找
    public int jump1(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

//    正向查找
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
