package zuochengyun_system.class10;

/**
 * @Author: bing
 * @date: 2023-12-18 10:55
 */
//https://leetcode.cn/problems/linked-list-cycle-ii/
public  class Code01_FindLoopNode {


    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
        } while (fast != slow);
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(3);
        ListNode listNode = new ListNode(2);
        head.next=listNode;
        head.next.next=new ListNode(0);
        ListNode listNode1 = new ListNode(-4);
        head.next.next.next=listNode1;
        listNode.next=listNode;*/
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        head.next=listNode;
        listNode.next=head;
        System.out.println(detectCycle(head).val);
    }
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
