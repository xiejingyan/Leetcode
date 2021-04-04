package leetcode;

public class _110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        return DFS(root) != -1;
    }
    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l, r;
        if ((l = DFS(root.left)) == -1 || (r = DFS(root.right)) == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        else {
            return Math.max(l, r) + 1;
        }
    }

//    自顶向下
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height1(root.left) - height1(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
        }
    }
    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height1(root.left), height1(root.right)) + 1;
        }
    }

//    自底向上
    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }
    public int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
