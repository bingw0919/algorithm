package zuochengyun_system.class03;

public class Code03_DeleteGivenValue {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// head = removeValue(head, 2);
	public static Node removeValue(Node head, int num) {
		if(head==null) return head;
		while (head!=null&&head.value==num) head=head.next;
		Node cur=head,next=head;
		while (next!=null){
			next=next.next;
			while (next!=null&&next.value==num) next=next.next;
			cur.next=next;
			cur=next;
		}
		return head;
	}

}
