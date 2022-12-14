package trees;

/*
 * Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= length of array <= 100000



Input Format
First argument is an integer array A.



Output Format
Return a root node of the Binary Search Tree.



Example Input
Input 1:

 A : [1, 2, 3]
Input 2:

 A : [1, 2, 3, 5, 10]


Example Output
Output 1:

      2
    /   \
   1     3
Output 2:

      3
    /   \
   2     5
  /       \
 1         10


Example Explanation
Explanation 1:

 You need to return the root node of the Binary Tree.
*/
public class SortedArrayToBalancedBST {
	public TreeNode sortedArrayToBST(final int[] A) {
		return createBBST(A, 0, A.length - 1);
	}

	public TreeNode createBBST(final int[] A, int left, int right) {

		if (left > right) {
			return null;
		}

		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(A[mid]);

		node.left = createBBST(A, left, mid - 1);
		node.right = createBBST(A, mid + 1, right);

		return node;
	}
}
