package zuochengyun_new.class07;

public class Code03_IsBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    public class Info {
        public int max;
        public int min;
        public boolean isBST;

        public Info(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public Info process(TreeNode root) {
        if (root == null) return null;
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int max = root.val, min = root.val;
        boolean isBST = false, leftFlag = true, rightFlag = true;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            leftFlag = leftInfo.isBST;
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.max, min);
            rightFlag = rightInfo.isBST;

        }
        isBST = (leftInfo == null || (root.val > leftInfo.max))
                && (rightInfo == null || (root.val < rightInfo.min)) && leftFlag && rightFlag;

        return new Info(max, min, isBST);
    }
}
