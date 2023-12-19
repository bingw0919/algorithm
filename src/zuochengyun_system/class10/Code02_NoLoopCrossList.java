package zuochengyun_system.class10;

import java.util.HashSet;

/**
 * @Author: bing
 * @date: 2023-12-19 14:33
 */
public class Code02_NoLoopCrossList {
    private class ListNode {
        int val;
        Code01_FindLoopNode.ListNode next;

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
        while (headA!=null){
            hashSet.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            if(hashSet.contains(headB))  return headB;
            headB=headB.next;
        }
        return null;
    }
}
