package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _104_maxDepth {
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }
    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = DFS(root.left), r = DFS(root.right);
        return Math.max(l, r) + 1;
    }

//    深搜
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

//    广搜
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
