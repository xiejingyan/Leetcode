package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _230_kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        LNR(list, root);
        return list.get(k - 1);
    }
    public void LNR(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        LNR(list, root.left);
        list.add(root.val);
        LNR(list, root.right);
    }

//    递归
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
    public int kthSmallest1(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

//    迭代
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
