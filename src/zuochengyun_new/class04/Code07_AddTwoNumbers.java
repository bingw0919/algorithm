package zuochengyun_new.class04;

// 测试链接：https://leetcode.com/problems/add-two-numbers/
public class Code07_AddTwoNumbers {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l==head1 ? head2 : head1;
        ListNode head=l;
        ListNode last = l;//last始终指向较长链表的最后一个节点而不为空，目的是保证需要进位时能够快速找到最后一个节点进行进位
        int  flag = 0, sum;
        //先算共有部分
        while (s != null) {
            sum = l.val + s.val + flag;
            flag = sum / 10;//进位
            l.val = sum % 10;//余数即为该数位对应的数字
            last = l;
            l = l.next;
            s = s.next;
        }
        //较长那部分考虑进位
        while (l != null) {
            sum = l.val + flag;
            flag = sum / 10;//进位
            l.val = sum % 10;
            last = l;
            l = l.next;
        }
        //考虑是否需要补个节点进行进位
        if (flag != 0) {
            last.next = new ListNode(1);
        }
        return head;//返回较长的那个链表
    }

    // 求链表长度
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
