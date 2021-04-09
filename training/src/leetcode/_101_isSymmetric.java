package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return DFS(root.left, root.right);
    }
    public boolean DFS(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left != null && right != null) {
            if (left.val == right.val) {
                return DFS(left.left, right.right) && DFS(left.right, right.left);
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

//    递归
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }
    public boolean check1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check1(p.left, q.right) && check1(p.right, q.left);
    }

//    迭代
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }
    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
