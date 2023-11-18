package zuochengyun_new.class07;

public class Code05_PathSum_1 {

    // 测试链接：https://leetcode.com/problems/path-sum
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        int lastSum = sum - root.val;
        boolean left = false, right = false;
        if (root.left != null) left = hasPathSum(root.left, lastSum);
        if (root.right != null) right = hasPathSum(root.right, lastSum);
        return left || right;
    }
}
