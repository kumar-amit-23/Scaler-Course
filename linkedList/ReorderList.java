package linkedList;

/*
 *Problem Description
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5] 
Input 2:

 A = [1, 2, 3, 4] 


Example Output
Output 1:

 [1, 5, 2, 4, 3] 
Output 2:

 [1, 4, 2, 3] 


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2]. 
*/
public class ReorderList {
	public ListNode reorderList(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}

		ListNode h1 = A;
		ListNode temp = findMiddle(A);
		ListNode h2 = temp.next;
		temp.next = null;

		h2 = reverse(h2);
		ListNode last = A;
		h1 = h1.next;

		// Merge
		int flag = 1;
		while (h1 != null && h2 != null) {
			if (flag == 1) {
				last.next = h2;
				h2 = h2.next;
				last = last.next;
				flag = 0;
			} else {
				last.next = h1;
				h1 = h1.next;
				last = last.next;
				flag = 1;
			}
		}

		if (h1 == null) {
			last.next = h2;
		} else {
			last.next = h1;
		}

		return A;

	}

	public ListNode reverse(ListNode A) {
		ListNode prev = null;
		ListNode curr = A;
		ListNode temp;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
	}

	public ListNode findMiddle(ListNode A) {
		ListNode prev = null;
		ListNode slow = A;
		ListNode fast = A;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		return prev;
	}
}
