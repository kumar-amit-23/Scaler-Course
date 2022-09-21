package trees.BST;

import trees.TreeNode;

/*
 * Problem Description
You are given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:

 
   1
  /  \
 2    3
Input 2:

 
  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.
*/
public class ValidBinarySearchTree {
	public int isValidBST(TreeNode A) {
		if (A.left == null && A.right == null) {
			return 1;
		}

		return isValid(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public int isValid(TreeNode A, int left, int right) {
		if (A == null) {
			return 1;
		}

		if (A.val > left && A.val < right) {
			return isValid(A.left, left, A.val) & isValid(A.right, A.val, right);
		} else {
			return 0;
		}
	}
}
