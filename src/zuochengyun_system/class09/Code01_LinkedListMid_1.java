package zuochengyun_system.class09;

import java.util.ArrayList;
import java.util.Random;

public class Code01_LinkedListMid_1 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    // 输入链表头节点，奇数返回中点，偶数返回上中点
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null)
                slow = slow.next;
        }
        return slow;
    }


    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 1) / 2);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxLen = random.nextInt(1000);
        int count = random.nextInt(1000);
        boolean flag = true;
        for (int j = 0; j < count; j++) {
            Node test = null;
            test = new Node(0);
            Node cur = test;
            for (int i = 0; i < maxLen; i++) {
                cur.next = new Node(random.nextInt(100));
                cur = cur.next;
            }

            Node ans1 = null;
            Node ans2 = null;

            ans1 = midOrUpMidNode(test);
            ans2 = right1(test);
            if (ans1 != ans2) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

}
