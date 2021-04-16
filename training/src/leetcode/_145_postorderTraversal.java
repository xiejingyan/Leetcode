package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _145_postorderTraversal {
    public List<Integer> _1_postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    public List<Integer> _2_postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.peekLast();
            if (treeNode.left != null || treeNode.right != null) {
                boolean flag = true;
                if (treeNode.right != null && !list.contains(treeNode.right)) {
                    stack.addLast(treeNode.right);
                    flag = false;
                }
                if (treeNode.left != null && !list.contains(treeNode.left)) {
                    stack.addLast(treeNode.left);
                    flag = false;
                }
                if (flag) {
                    stack.pollLast();
                    res.add(treeNode.val);
                    list.add(treeNode);
                }
            }
            else {
                stack.pollLast();
                res.add(treeNode.val);
                list.add(treeNode);
            }

        }
        return res;
    }

//    递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

//    迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
