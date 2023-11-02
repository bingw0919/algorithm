package zuochengyun_new.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

// 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
public class Code02_MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode();
        ListNode cur = head;
        for (ListNode node : lists) {
            if (node != null) priorityQueue.add(node);
        }
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
            if (cur.next != null) priorityQueue.add(cur.next);
        }
        return head.next;
    }

}
