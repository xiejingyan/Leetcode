package leetcode;

import java.util.*;

public class _103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = false;
        Deque<TreeNode> lift = new LinkedList<>();
        Deque<TreeNode> right = new LinkedList<>();
        if (root != null) {
            lift.add(root);
        }
        while (!lift.isEmpty() || !right.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            if (flag) {
                while (!right.isEmpty()) {
                    TreeNode node = right.pollLast();
                    nums.add(node.val);
                    if (node.right != null) {
                        lift.add(node.right);
                    }
                    if (node.left != null) {
                        lift.add(node.left);
                    }
                }
                res.add(nums);
                flag = false;
            }
            else {
                while (!lift.isEmpty()) {
                    TreeNode node = lift.pollLast();
                    nums.add(node.val);
                    if (node.left != null) {
                        right.add(node.left);
                    }
                    if (node.right != null) {
                        right.add(node.right);
                    }
                }
                res.add(nums);
                flag = true;
            }
        }
        return res;
    }

//    广度优先遍历
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

//    递归
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root,res,0);
        return res;
    }
    private void traversal(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        if((level & 1) == 1){
            //如果level是奇数，其实实际上层数是偶数，那么应该已经是从右往左了
            res.get(level).add(0,root.val);
        }else{
            res.get(level).add(root.val);
        }
        traversal(root.left,res,level + 1);
        traversal(root.right,res,level + 1);
    }
}
