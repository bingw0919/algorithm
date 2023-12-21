package zuochengyun_system.class10;

/**
 * @Author: bing
 * @date: 2023-12-20 9:10
 */
public class Code03_LoopCrossList {
    /**
     * 寻找链表1和2的交叉节点
     *
     * @param head1 链表1头节点
     * @param loop1 环1
     * @param head2 链表2头节点
     * @param loop2 环2
     * @return 交叉节点
     */
    public static ListNode getIntersectionNode(ListNode head1, ListNode loop1,
                                        ListNode head2, ListNode loop2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        //共环
        if (loop1 == loop2) {
            int len = 0;
            ListNode cur1 = head1, cur2 = head2;
            while (cur1.next != loop1) {
                len++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                len--;
                cur2 = cur2.next;
            }
            cur1 = head1;
            cur2 = head2;
            if (len > 0) {
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
        } else {
            ListNode cur = loop1;
            while (cur.next != loop1) {
                if (cur == loop2) {
                    return cur;
                }
                cur = cur.next;
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        //无环
/*        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        head1.next = node11;
        node11.next=node12;
        node12.next=node13;
        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        head2.next = node21;
        node21.next=node22;
        node22.next=node23;
        System.out.println(getIntersectionNode(head1,null,head2,null));*/
        //共环共节点
        /*ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        head1.next = node11;
        node11.next=node12;
        node12.next=node13;
        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        head2.next = node21;
        node21.next=node22;

        ListNode node=new ListNode(100);
        ListNode node1 = new ListNode(101);
        ListNode node2 = new ListNode(102);
        node.next=node1;
        node1.next=node2;
        node13.next=node;
        node22.next=node;
//        node2.next=node;
        node2.next=node1;
//        System.out.println(getIntersectionNode(head1,node,head2,node).val);
        System.out.println(getIntersectionNode(head1,node1,head2,node1).val);*/
        //共环不共节点
        ListNode loopNode=new ListNode(100);
        ListNode loopNode1=new ListNode(101);
        ListNode loopNode2=new ListNode(102);
        ListNode loopNode3=new ListNode(103);
        ListNode loopNode4=new ListNode(104);
        loopNode.next=loopNode1;
        loopNode1.next=loopNode2;
        loopNode2.next=loopNode3;
        loopNode3.next=loopNode4;
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        head1.next = node11;
        node11.next=node12;
        node12.next=node13;
        node13.next=loopNode1;
        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        head2.next = node21;
        node21.next=node22;
        node12.next=loopNode3;
        System.out.println(getIntersectionNode(head1,loopNode1,head2,loopNode3).val);
    }
}
