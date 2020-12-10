package leetcode;

public class _226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        else if (root.left != null || root.right != null) {
            TreeNode tn = root.left;
            root.left = root.right;
            root.right = tn;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
        else {
            return root;
        }
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
