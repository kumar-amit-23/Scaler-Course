package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class DeserializeBinaryTree {
	public TreeNode solve(ArrayList<Integer> A) {

		Queue<TreeNode> q1 = new LinkedList<>();

		int indx = 0;
		int n = A.size();

		TreeNode node = new TreeNode(A.get(indx++));
		TreeNode root = node;
		q1.add(node);
		while (indx < n) {
			TreeNode currNode = q1.poll();

			if (A.get(indx) != -1) {
				TreeNode left = new TreeNode(A.get(indx));
				currNode.left = left;
				q1.add(left);
			}
			indx++;

			if (indx >= n)
				break;

			if (A.get(indx) != -1) {
				TreeNode right = new TreeNode(A.get(indx));
				currNode.right = right;
				q1.add(right);
			}

			indx++;

		}

		return root;

	}
}
