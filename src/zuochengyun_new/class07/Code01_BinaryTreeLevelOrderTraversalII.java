package zuochengyun_new.class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class Code01_BinaryTreeLevelOrderTraversalII {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans=new LinkedList<>();
		if (root==null) return ans;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			List<Integer> arr=new LinkedList<>();
			for (int size=queue.size();size>0;size--){
				TreeNode node=queue.poll();
				arr.add(node.val);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			ans.add(0,arr);
		}
		return ans;
	}

}
