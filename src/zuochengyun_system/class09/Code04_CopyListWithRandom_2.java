package zuochengyun_system.class09;

import java.util.HashMap;

public class Code04_CopyListWithRandom_2 {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRand1(Node head) {
        if (head == null) return head;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node newHead = null, newCur = null;
        Node cur = head;
        //复制链表
        while (cur != null) {
            if (newHead == null) {
                newHead = new Node(cur.value);
                newCur = newHead;
            } else {
                newCur.next = new Node(cur.value);
                newCur = newCur.next;
            }
            map.put(cur, newCur);
            cur = cur.next;
        }
        //复制随机节点
        cur = head;
        newCur = newHead;
        while (cur != null) {
            Node oldRand = cur.rand;
            newCur.rand = map.get(oldRand);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null) return head;
        Node cur = head, tmp = null;
        //复制链表节点
        while (cur != null) {
            tmp = cur.next;
            cur.next = new Node(cur.value);
            cur = cur.next;
            cur.next = tmp;
            cur = cur.next;
        }
        //复制随机节点
        cur = head;
        while (cur != null) {
            if (cur.rand != null) {
                cur.next.rand = cur.rand.next;
            }
            cur = cur.next.next;
        }
        //拆分链表
        cur = head;
        Node newHead = new Node(0), newCur = newHead;
        while (cur != null) {
            newCur.next = cur.next;
            newCur = newCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return newHead.next;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");
        res1 = copyListWithRand1(head);
        System.out.println("方法一的拷贝链表：");
        printRandLinkedList(res1);
        System.out.println("=========================");
        res2 = copyListWithRand2(head);
        System.out.println("方法二的拷贝链表：");
        printRandLinkedList(res2);
        System.out.println("=========================");
        System.out.println("经历方法二拷贝之后的原始链表：");
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
