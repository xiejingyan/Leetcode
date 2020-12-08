package leetcode;

public class _530_getMinimumDifference {
    boolean[] key = new  boolean[10000];
    public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            getMinimumDifference(root.left);
            key[root.val] = true;
            getMinimumDifference(root.right);
        }
        int result = 10000;
        int a = -1;
        for (int i = 0; i < key.length; i++) {
            if (key[i]) {
                if (a != -1) {
                    result = Math.min((i - a), result);
                }
                a = i;
            }
        }
        return result;
    }

    int pre;
    int ans;
    public int getMinimumDifference2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
