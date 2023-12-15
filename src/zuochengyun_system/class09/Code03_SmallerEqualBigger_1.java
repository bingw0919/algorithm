package zuochengyun_system.class09;

public class Code03_SmallerEqualBigger_1 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        if (head == null) return head;
        Node head1 = null, head2 = null, head3 = null,
                cur1 = null, cur2 = null, cur3 = null, cur = head;
        //成三个链表
        Node tmp=null;
        while (cur != null) {
            tmp=cur.next;
            cur.next=null;
            if (cur.value < pivot) {
                if (head1 == null) {
                    head1 = cur;
                    cur1 = cur;
                } else {
                    cur1.next = cur;
                    cur1 = cur1.next;
                }
            } else if (cur.value == pivot) {
                if (head2 == null) {
                    head2 = cur;
                    cur2 = cur;
                } else {
                    cur2.next = cur;
                    cur2 = cur2.next;
                }
            } else {
                if (head3 == null) {
                    head3 = cur;
                    cur3 = cur;
                } else {
                    cur3.next = cur;
                    cur3 = cur3.next;
                }
            }
            cur = tmp;
        }
        head = head1 != null ? head1 : (head2 == null ? head2 : head3);
        if (head.equals(head1)) {
            if (head2 != null) {
                cur1.next = head2;
                cur2.next = head3;
            } else {
                cur1.next = head3;
            }
        } else if (head.equals(head2)) {
            cur2.next = head3;
        } else {
        }
        return head;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

}
