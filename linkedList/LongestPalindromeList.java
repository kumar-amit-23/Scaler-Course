package linkedList;

/*
 * Problem Description
Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)



Problem Constraints
1 <= length of the linked list <= 2000

1 <= Node value <= 100



Input Format
The only argument given is head pointer of the linked list.



Output Format
Return the length of the longest palindrome list.



Example Input
Input 1:

 2 -> 3 -> 3 -> 3
Input 2:

 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2


Example Output
Output 1:

 3
Output 2:

 5


Example Explanation
Explanation 1:

 3 -> 3 -> 3 is largest palindromic sublist
Explanation 2:

 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
*/
public class LongestPalindromeList {
	public int solve(ListNode A) {
		if (A == null) {
			return 0;
		}

		if (A.next == null) {
			return 1;
		}
		ListNode prev = null;
		ListNode curr = A;
		int ans = 0;
		ListNode temp;
		while (curr != null) {
			temp = curr.next;
			curr.next = prev;

			ans = Math.max(ans, 2 * count(curr, temp));

			ans = Math.max(ans, 2 * count(prev, temp) + 1);

			prev = curr;
			curr = temp;
		}

		return ans;
	}

	public int count(ListNode A, ListNode B) {
		int num = 0;

		while (A != null && B != null) {
			if (A.val != B.val) {
				return num;
			}

			num++;
			A = A.next;
			B = B.next;
		}

		return num;
	}

}
