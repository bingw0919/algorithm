package zuochengyun_system.class10;

import java.util.HashSet;

/**
 * @Author: bing
 * @date: 2023-12-19 14:33
 */
public class Code02_NoLoopCrossList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hashSet.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA, cur2 = headB;
        int len = 0;
        while (cur1.next != null) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            len--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) return null;
        cur1 = headA;
        cur2 = headB;
        if (len > 0) {
            len = Math.abs(len);
            while (len != 0) {
                cur1 = cur1.next;
                len--;
            }
        } else {
            len = Math.abs(len);
            while (len != 0) {
                cur2 = cur2.next;
                len--;
            }
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
