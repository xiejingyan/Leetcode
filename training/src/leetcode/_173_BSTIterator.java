package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _173_BSTIterator {
    List<Integer> bst;
    int tmp;
    public _173_BSTIterator(TreeNode root) {
        bst = new ArrayList<>();
        tmp = 0;
        bst.add(-1);
        setBst(root, bst);
    }
    public void setBst(TreeNode root, List<Integer> bst) {
        if (root.left != null) {
            setBst(root.left, bst);
        }
        bst.add(root.val);
        if (root.right != null) {
            setBst(root.right, bst);
        }
    }
    public int next() {
        return bst.get(++tmp);
    }
    public boolean hasNext() {
        return tmp + 1 < bst.size();
    }

//    扁平化
    private int idx;
    private List<Integer> arr;
//    public BSTIterator(TreeNode root) {
//        idx = 0;
//        arr = new ArrayList<Integer>();
//        inorderTraversal(root, arr);
//    }
    public int next1() {
        return arr.get(idx++);
    }
    public boolean hasNext1() {
        return idx < arr.size();
    }
    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

//    迭代
    private TreeNode cur;
    private Deque<TreeNode> stack;
//    public BSTIterator(TreeNode root) {
//        cur = root;
//        stack = new LinkedList<TreeNode>();
//    }
    public int next2() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }
    public boolean hasNext2() {
        return cur != null || !stack.isEmpty();
    }
}
