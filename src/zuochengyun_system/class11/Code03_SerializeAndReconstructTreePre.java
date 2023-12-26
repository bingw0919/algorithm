package zuochengyun_system.class11;

import java.util.*;

public class Code03_SerializeAndReconstructTreePre {

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
        if(root==null) return null;
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        return sb.toString();
    }
    private void preSerialize(TreeNode root,StringBuilder sb) {
        if(root==null){
            sb.append("null,");
        }else {
            sb.append(root.val).append(",");
            preSerialize(root.left,sb);
            preSerialize(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] split = data.split(",");
        Queue<String> list = new LinkedList<>();
        Collections.addAll(list, split);
        return deserialize(list);
    }
    private TreeNode deserialize(Queue<String> queue) {
        if(queue==null|| queue.isEmpty()) return null;
        if(Objects.equals(queue.peek(), "null")){
            queue.poll();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}
