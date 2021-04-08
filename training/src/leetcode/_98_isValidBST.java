package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.val <= root.left.val) {
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        return DFS(root.left, Long.MIN_VALUE, root.val) && DFS(root.right, root.val, Long.MAX_VALUE);
    }
    public boolean DFS(TreeNode root, long l, long r) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val <= root.left.val || root.left.val <= l) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val >= root.right.val || root.right.val >= r) {
                return false;
            }
        }
        return DFS(root.left, l, root.val) && DFS(root.right, root.val, r);
    }

//    递归
    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST1(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST1(node.left, lower, node.val) && isValidBST1(node.right, node.val, upper);
    }

//    中序遍历
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
