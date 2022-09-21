package trees;

/*
 * Problem Description
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.



Problem Constraints
1 <= size of tree <= 100000

1 <= B, C <= 109



Input Format
First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.



Output Format
Return the LCA.



Example Input
Input 1:

 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 LCA is 1.
Explanation 2:

 LCA is 2.

*/
public class LeastCommonAncestor {
	public int lca(TreeNode A, int B, int C) {
		if (A == null) {
			return -1;
		}

		if (!find(A, B) || !find(A, C)) {
			return -1;
		}

		TreeNode ans = solve(A, B, C);

		if (ans == null) {
			return -1;
		}

		return ans.val;

	}

	public TreeNode solve(TreeNode A, int B, int C) {
		if (A == null) {
			return null;
		}

		if (A.val == B || A.val == C) {
			return A;
		}

		TreeNode left = solve(A.left, B, C);
		TreeNode right = solve(A.right, B, C);

		if (left != null && right != null) {
			return A;
		}

		if (left != null) {
			return left;
		}

		if (right != null) {
			return right;
		}

		return null;
	}

	boolean find(TreeNode A, int k) {
		if (A == null) {
			return false;
		}
		if (A.val == k) {
			return true;
		}

		boolean left = find(A.left, k);
		boolean right = find(A.right, k);

		if (left == true || right == true) {
			return true;
		}

		return false;
	}
}
