package zuochengyun_new.class06;

// 测试链接：https://leetcode.com/problems/symmetric-tree
public class Code05_SymmetricTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p == null && q == null) return true;
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }


}
