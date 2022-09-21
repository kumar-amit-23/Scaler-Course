package linkedList;

/*
 *Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input
Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
Output 1:

 1 
Output 2:

 0 


Example Explanation
Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1]. 
*/
public class PalindromeList {
	public int lPalin(ListNode A) {

		if (A == null || A.next == null) {
			return 1;
		}

		ListNode Middle = findMiddle(A);
		ListNode rev = reverse(Middle.next);
		Middle.next = null;
		ListNode temp = A;

		while (temp != null && rev != null) {
			if (temp.val != rev.val) {
				return 0;
			}

			temp = temp.next;
			rev = rev.next;
		}

		return 1;
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

		return temp;
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

}
