package leetcode;

import java.util.*;

public class _236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> pr = new LinkedList<>();
        pr.addLast(root);
        Deque<TreeNode> qr = new LinkedList<>();
        qr.addLast(root);
        dfs(pr, p);
        dfs(qr, q);
        TreeNode res = root;
        while (pr.peekFirst() == qr.peekFirst()) {
            res = pr.pollFirst();
            qr.pollFirst();
        }
        return res;
    }
    public void dfs(Deque<TreeNode> r, TreeNode target) {
        if (r.peekLast() != target) {
            if (r.peekLast().left != null) {
                r.addLast(r.peekLast().left);
                dfs(r, target);
                if (r.peekLast() == target) {
                    return;
                }
            }
            if (r.peekLast().right != null) {
                r.addLast(r.peekLast().right);
                dfs(r, target);
                if (r.peekLast() == target) {
                    return;
                }
            }
            r.pollLast();
        }
    }

//    递归
    private TreeNode ans;
    public _236_lowestCommonAncestor() {
        this.ans = null;
    }
    private boolean dfs1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs1(root.left, p, q);
        boolean rson = dfs1(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs1(root, p, q);
        return this.ans;
    }

//    存储父节点
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    public void dfs2(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs2(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs2(root.right);
        }
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
