package zuochengyun_new.class04;

// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code06_ReverseNodesInKGroup {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end != null) {
            head = end;//第一组反转后的第一个节点将是整个链表的头节点
        }
        reverse(start, end);
        ListNode lastEnd = start;//保存上一组反转后的最后节点用于链接
        while (end != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            //没有足够的节点能够成组
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
            //这步没必要，连接到下一组的头节点reverse（）已经做好了
//            start.next = end.next;
        }
        return head;
    }

    /**
     * 寻找每组链表最末尾的节点
     *
     * @param start 起始节点
     * @param k     每组节点个数
     * @return 尾节点
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    /**
     * 反转单个小组的链表
     *
     * @param start 起始
     * @param end   结尾
     */
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null, next = null, cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = next;
    }

}
