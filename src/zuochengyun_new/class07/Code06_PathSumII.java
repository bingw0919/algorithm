package zuochengyun_new.class07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code06_PathSumII {

    // 测试链接：https://leetcode.com/problems/path-sum-ii
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<Integer> list = new LinkedList<>();
        process(root, sum, result, list);
        return result;
    }

    public static void process(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                list.add(root.val);
                result.add(new LinkedList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }
        list.add(root.val);
        if (root.left != null) process(root.left, sum, result, list);
        if (root.right != null) process(root.right, sum, result, list);
        list.remove(list.size() - 1);
    }

}
