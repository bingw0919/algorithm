package zuochengyun_system.class10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Code06_NoRecursiveTraversalBTLast {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if(node.left!= null) stack.push(node.left);
            if(node.right!= null) stack.push(node.right);
        }
        return list;
    }


}

