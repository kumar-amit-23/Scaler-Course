package linkedList;

/*
 * Problem Description
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output
Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation
Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
*/
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ReverseLinkListII {
	public ListNode reverseBetween(ListNode A, int B, int C) {
		if (B - C == 0) {
			return A;
		}
		int start = B - 1;
		int end = C - 1;

		ListNode nm1 = null;

		for (int i = 0; i < start; i++) {
			if (i == 0) {
				nm1 = A;
			} else {
				nm1 = nm1.next;
			}
		}

		if (nm1 == null) {
			ListNode prev = A;
			ListNode curr = prev.next;
			ListNode ahead = curr.next;
			for (int i = 0; i < end - start - 1 && ahead != null; i++) {
				curr.next = prev;
				prev = curr;
				curr = ahead;
				ahead = ahead.next;
			}
			curr.next = prev;
			A.next = ahead;
			A = curr;
			return A;
		} else {
			ListNode prev = nm1.next;
			ListNode curr = prev.next;
			ListNode ahead = curr.next;
			for (int i = 0; i < end - start - 1 && ahead != null; i++) {
				curr.next = prev;
				prev = curr;
				curr = ahead;
				ahead = ahead.next;
			}
			curr.next = prev;
			nm1.next.next = ahead;
			nm1.next = curr;
			return A;
		}
	}

}
