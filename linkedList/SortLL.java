package linkedList;

/*
 *Problem Description
Sort a linked list, A in O(n log n) time using constant space complexity.



Problem Constraints
0 <= |A| = 105



Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.



Output Format
Return a pointer to the head of the sorted linked list.



Example Input
Input 1:

A = [3, 4, 2, 8]
Input 2:

A = [1]


Example Output
Output 1:

[2, 3, 4, 8]
Output 2:

[1]


Example Explanation
Explanation 1:

 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:

 The sorted form of [1] is [1]. 
*/
public class SortLL {
	public ListNode sortList(ListNode A) {
		if (A == null || A.next == null)
			return A;

		ListNode h1 = A;
		ListNode h2 = findMiddle(A);

		h1 = sortList(h1);
		h2 = sortList(h2);

		return merge(h1, h2);
	}

	public ListNode merge(ListNode h1, ListNode h2) {
		ListNode head, tail;

		if (h1 == null) {
			return h2;
		}

		if (h2 == null) {
			return h1;
		}

		if (h1.val > h2.val) {
			head = h2;
			tail = h2;
			h2 = h2.next;
		} else {
			head = h1;
			tail = h1;
			h1 = h1.next;
		}

		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				tail.next = h1;
				h1 = h1.next;
				tail = tail.next;
			} else {
				tail.next = h2;
				h2 = h2.next;
				tail = tail.next;
			}
		}

		if (h1 != null) {
			tail.next = h1;
		} else {
			tail.next = h2;
		}

		return head;
	}

	public ListNode findMiddle(ListNode A) {
		ListNode temp = null;
		ListNode slow = A;
		ListNode fast = A;

		while (fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		temp.next = null;
		return slow;
	}

}
