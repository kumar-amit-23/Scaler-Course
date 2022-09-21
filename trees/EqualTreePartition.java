package trees;

/*
 * Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints
1 <= size of tree <= 100000

0 <= value of node <= 109



Input Format
First and only argument is head of tree A.



Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input
Input 1:

 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:

 
                1
               / \
              2   10
                  / \
                 20  2


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.

*/

public class EqualTreePartition {
	boolean flag = false;

	public int solve(TreeNode A) {

		long sum = sum(A);
		if (sum % 2 == 1) {
			return 0;
		}
		isPossible(A, sum / 2);
		if (flag)
			return 1;

		return 0;
	}

	public long isPossible(TreeNode A, long sum) {
		if (A == null)
			return 0;

		long left = isPossible(A.left, sum);
		long right = isPossible(A.right, sum);

		if (left == sum) {
			flag = true;
			return left;
		}

		if (right == sum) {
			flag = true;
			return right;
		}

		return left + right + A.val;

	}

	public long sum(TreeNode A) {
		if (A == null)
			return 0;

		return sum(A.left) + sum(A.right) + A.val;
	}
}
