package leetcode;

public class _11_maxArea {
    public int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while ((j - i) != 0) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return res;
    }

//    双指针
    public int maxArea1(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while ((j - i) != 0) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        return res;
    }
}
