package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _228_summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length > 0) {
            int tmp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    if (nums[i - 1] == tmp) {
                        res.add(tmp + "");
                    }
                    else {
                        res.add(tmp + "->" + nums[i - 1]);
                    }
                    tmp = nums[i];
                }
            }
            if (nums[nums.length - 1] == tmp) {
                res.add(tmp + "");
            }
            else {
                res.add(tmp + "->" + nums[nums.length - 1]);
            }
        }
        return res;
    }

//    一次遍历
    public List<String> summaryRanges1(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
