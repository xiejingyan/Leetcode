package leetcode;

import java.util.*;

public class _102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        list.addLast(root);
        while (!list.isEmpty()) {
            List<Integer> re = new ArrayList<>();
            List<TreeNode> n = new ArrayList<>();
            while (!list.isEmpty()) {
                TreeNode treeNode = list.pollFirst();
                re.add(treeNode.val);
                if (treeNode.left != null) {
                    n.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    n.add(treeNode.right);
                }
            }
            for (TreeNode treeNode : n) {
                list.addLast(treeNode);
            }
            res.add(re);
        }
        return res;
    }

//    广度优先搜索
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
