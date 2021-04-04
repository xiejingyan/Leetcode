package leetcode;

public class _543_diameterOfBinaryTree {
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return maxD;
    }
    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = DFS(root.left), r = DFS(root.right);
        maxD = Math.max(l + r, maxD);
        return Math.max(l, r) + 1;
    }

//    深搜
    int ans;
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
