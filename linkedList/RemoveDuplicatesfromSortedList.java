package linkedList;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode A) {
		HashSet<Integer> set = new HashSet<>();

		ListNode temp = A;
		set.add(temp.val);
		while (temp != null && temp.next != null) {
			if (set.contains(temp.next.val)) {
				temp.next = temp.next.next;
			} else {
				set.add(temp.next.val);
				temp = temp.next;
			}

		}

		return A;
	}

}
