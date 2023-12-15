package zuochengyun_system.class09;

public class Code03_SmallerEqualBigger_2 {

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
        int len = 0;
        //获取链表长度
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        Node[] arr = new Node[len];
        //将链表数据放到数组中
        cur = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cur;
            cur = cur.next;
            arr[i].next = null;
        }
        int L = 0, R = arr.length - 1, index = 0;
        while (index <= R) {
            if (arr[index].value > pivot) {
                swap(arr, index, R--);
            } else if (arr[index].value == pivot) {
                index++;
            } else {
                swap(arr, index++, L++);
            }
        }
        head = arr[0];
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = arr[i];
            cur = cur.next;
        }
        return head;
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
        Node tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = null;
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
        head = head1 != null ? head1 : ((head2 != null) ? head2 : head3);
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
        for (int i = 0; i < 100; i++) {
            Node head1 = new Node((int) (Math.random() * 10));
            Node cur = head1;
            for (int j = 0; j < (int) (Math.random() * 10)*10; j++) {
                cur.next = new Node((int) (Math.random() * 20));
                cur = cur.next;
                printLinkedList(head1);
                head1 = listPartition1(head1, 10);
//                head1 = listPartition2(head1, 10);
                printLinkedList(head1);
            }
        }

    }
}