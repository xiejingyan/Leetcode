package leetcode;

import java.util.*;

public class _144_preorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        preorder(root, result);
        return result;
    }
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode tmp;
        tmp = root;
        while (tmp != null || !stack.isEmpty()) {
            if (tmp != null) {
                result.add(tmp.val);
                stack.addLast(tmp);
                tmp = tmp.left;
            } else tmp = stack.pollLast().right;
        }
        return result;
    }
}
