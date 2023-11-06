package zuochengyun_new.class06;

// 测试链接：https://leetcode.com/problems/maximum-depth-of-binary-tree
public class Code06_MaximumDepthOfBinaryTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 以root为头的树，最大高度是多少返回！
	public static int maxDepth(TreeNode root) {
		if(root==null) return 0;
		int left=maxDepth(root.left);
		int right=maxDepth(root.right);
		return left>right?left+1:right+1;
	}

}
