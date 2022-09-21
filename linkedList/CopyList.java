package linkedList;

/*
 * Problem Description
A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.



Problem Constraints
0 <= |A| <= 106



Input Format
The first argument of input contains a pointer to the head of linked list A.



Output Format
Return a pointer to the head of the required linked list.



Example Input
Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Output
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Explanation
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
*/
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

public class CopyList {
	public RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode temp = head;

		while (temp != null) {
			RandomListNode nn = new RandomListNode(temp.label);
			nn.next = temp.next;
			temp.next = nn;

			temp = nn.next;
		}

		RandomListNode temp1 = head;
		RandomListNode temp2 = head.next;

		while (temp1 != null) {
			if (temp1.random != null)
				temp2.random = temp1.random.next;

			temp1 = temp1.next.next;
			if (temp2.next != null)
				temp2 = temp2.next.next;
		}

		temp = head.next;

		while (temp != null && temp.next != null) {
			temp.next = temp.next.next;
			temp = temp.next;
		}

		return head.next;

	}

}
