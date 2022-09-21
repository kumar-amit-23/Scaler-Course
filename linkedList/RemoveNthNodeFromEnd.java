package linkedList;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode A, int B) {
		int n;
		ListNode node;
		if (A == null)
			return null;
		n = 0;
		node = A;
		while (node != null) {
			n++;
			node = node.next;
		}
		if (B >= n) {
			return A.next;
		}
		node = A;
		for (int i = 0; i < n - B - 1; i++)
			node = node.next;
		node.next = node.next.next;
		return A;
	}

}
