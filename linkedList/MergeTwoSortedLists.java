package linkedList;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode A, ListNode B) {

		if (A == null) {
			return B;
		}

		if (B == null) {
			return A;
		}

		ListNode head, tail;
		ListNode h1 = A;
		ListNode h2 = B;
		if (A.val > B.val) {
			head = B;
			tail = B;
			h2 = h2.next;
		} else {
			head = A;
			tail = A;
			h1 = h1.next;
		}

		while (h1 != null && h2 != null) {
			if (h1.val > h2.val) {
				tail.next = h2;
				h2 = h2.next;
				tail = tail.next;
			} else {
				tail.next = h1;
				h1 = h1.next;
				tail = tail.next;
			}
		}

		if (h1 != null) {
			tail.next = h1;
		}

		if (h2 != null) {
			tail.next = h2;
		}

		return head;
	}

}
