package zuochengyun_system.class11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Code04_SerializeAndReconstructTreeLevel {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int i) {
            val = i;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        sb.append(root.val).append('#');
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.add(left);
                sb.append(left.val).append('#');
            } else {
                sb.append("null").append('#');
            }
            if (right != null) {
                queue.add(right);
                sb.append(right.val).append('#');
            } else {
                sb.append("null").append('#');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] split = data.split("#");
        Queue<TreeNode> sourceArr = new LinkedList<>();
        for (String s : split) {
            sourceArr.add(getTreeNode(s));
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (sourceArr.peek() == null) return null;
        queue.add(sourceArr.peek());
        TreeNode root = sourceArr.poll();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = sourceArr.poll();
            TreeNode right = sourceArr.poll();
            node.left = left;
            node.right = right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
        return root;
    }

    private TreeNode getTreeNode(String name) {
        if (name == null || "null".equals(name)) return null;
        return new TreeNode(Integer.parseInt(name));
    }
}
