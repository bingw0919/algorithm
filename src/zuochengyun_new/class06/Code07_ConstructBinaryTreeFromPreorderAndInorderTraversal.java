package zuochengyun_new.class06;

import java.util.HashMap;

//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class Code07_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return f1(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private static TreeNode f1(int[] pre, int L1, int R1, int[] in, int L2, int R2,HashMap<Integer,Integer> map) {
        if(L1>R1||L2>R2) return null;
        if(L1==R1||L2==R2) return new TreeNode(pre[L1]);
        TreeNode head = new TreeNode(pre[L1]);
        int find=map.get(pre[L1]);
        head.left=f1(pre,L1+1,find-L2+L1,in,L2,find-1,map);
        head.right=f1(pre,find-L2+L1+1,R1,in,find+1,R2,map);
        return head;
    }
    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return f2(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode f2(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if(L1>R1||L2>R2) return null;
        if(L1==R1||L2==R2) return new TreeNode(pre[L1]);
        TreeNode head = new TreeNode(pre[L1]);
        int find=L2;
        while (pre[L1]!=in[find]) find++;
        head.left=f2(pre,L1+1,find-L2+L1,in,L2,find-1);
        head.right=f2(pre,find-L2+L1+1,R1,in,find+1,R2);
        return head;
    }
}
