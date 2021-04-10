package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _958_isCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.addLast(root);
        boolean flag = false;
        while (!nodeDeque.isEmpty()) {
            int n = nodeDeque.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = nodeDeque.pollFirst();
                if (node != null) {
                    if (flag) {
                        return false;
                    }
                    nodeDeque.addLast(node.left);
                    nodeDeque.addLast(node.right);
                }
                else {
                    if (!flag) {
                        flag = true;
                    }
                }
            }
        }
        return true;
    }

//    广搜
    public boolean isCompleteTree1(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i-1).code == nodes.size();
    }
}
class ANode {  // Annotated Node
    TreeNode node;
    int code;
    ANode(TreeNode node, int code) {
        this.node = node;
        this.code = code;
    }
}
