package zuochengyun_new.class04;

// 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
public class Code08_MergeTwoSortedLinkedList {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if(head1==null) return head2;
		if (head2==null) return head1;
		ListNode head = new ListNode();
		ListNode cur=head;
		while (head1!=null&&head2!=null){
			if (head1.val< head2.val){
				cur.next=head1;
				head1=head1.next;
			}else {
				cur.next=head2;
				head2=head2.next;
			}
			cur=cur.next;
		}
		cur.next=(head1==null)?head2:head1;
		return head.next;
	}

}
