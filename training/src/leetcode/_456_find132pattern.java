package leetcode;

import java.util.*;

public class _456_find132pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int i, j = -1, t;
        while (j < nums.length - 3) {
            i = j + 1;
            for (t = i + 1; t < nums.length; t++) {
                if (nums[i] >= nums[t]) {
                    i = t;
                }
                else {
                    j = t;
                    break;
                }
            }
            for (; t < nums.length; t++) {
                if (nums[j] <= nums[t]) {
                    j = t;
                }
                else {
                    break;
                }
            }
            for (; t < nums.length; t++) {
                if (nums[t] > nums[i] && nums[t] < nums[j]) {
                    return true;
                }
            }
            if (i > nums.length - 3) {
                break;
            }
        }
        return false;
    }

//    枚举3
    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }

//    枚举1
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }

//    枚举2
    public boolean find132pattern3(int[] nums) {
        int n = nums.length;
        List<Integer> candidateI = new ArrayList<Integer>();
        candidateI.add(nums[0]);
        List<Integer> candidateJ = new ArrayList<Integer>();
        candidateJ.add(nums[0]);

        for (int k = 1; k < n; ++k) {
            int idxI = binarySearchFirst(candidateI, nums[k]);
            int idxJ = binarySearchLast(candidateJ, nums[k]);
            if (idxI >= 0 && idxJ >= 0) {
                if (idxI <= idxJ) {
                    return true;
                }
            }

            if (nums[k] < candidateI.get(candidateI.size() - 1)) {
                candidateI.add(nums[k]);
                candidateJ.add(nums[k]);
            } else if (nums[k] > candidateJ.get(candidateJ.size() - 1)) {
                int lastI = candidateI.get(candidateI.size() - 1);
                while (!candidateJ.isEmpty() && nums[k] > candidateJ.get(candidateJ.size() - 1)) {
                    candidateI.remove(candidateI.size() - 1);
                    candidateJ.remove(candidateJ.size() - 1);
                }
                candidateI.add(lastI);
                candidateJ.add(nums[k]);
            }
        }

        return false;
    }
    public int binarySearchFirst(List<Integer> candidate, int target) {
        int low = 0, high = candidate.size() - 1;
        if (candidate.get(high) >= target) {
            return -1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int num = candidate.get(mid);
            if (num >= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public int binarySearchLast(List<Integer> candidate, int target) {
        int low = 0, high = candidate.size() - 1;
        if (candidate.get(low) <= target) {
            return -1;
        }
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int num = candidate.get(mid);
            if (num <= target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }
}
