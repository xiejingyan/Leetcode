package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            listAdd(res, new ArrayList<>(), nums, 0, i);
        }
        return res;
    }
    public void listAdd(List<List<Integer>> res, List<Integer> r, int[] nums, int s, int n) {
        if (n <= 0) {
            res.add(r);
            return;
        }
        for (int i = s; i <= nums.length - n; i++) {
            List<Integer> re = new ArrayList<>(r);
            re.add(nums[i]);
            listAdd(res, re, nums, i + 1, n - 1);
        }
    }

//    迭代
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

//    递归
//    List<Integer> t = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
