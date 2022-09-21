package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109



Input Format
First and only argument is a root node of the binary tree, A



Output Format
Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.



Example Input
Input 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8 
Input 2:

        1
       / \
      2   10
       \
        4


Example Output
Output 1:

 10
Output 2:

 -7


Example Explanation
Explanation 1:

 Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13
Explanation 2:

 Sum of nodes at odd level = 5
 Sum of ndoes at even level = 12
*/
public class OddAndEvenLevels {
	public int solve(TreeNode A) {

		Queue<TreeNode> queue = new LinkedList<>();

		int odd = 0;
		int even = 0;

		queue.add(A);
		queue.add(null);

		int level = 1;
		while (queue.size() > 1) {
			TreeNode temp = queue.poll();

			if (temp == null) {
				queue.add(null);
				level++;
				continue;
			}

			if (level % 2 == 0) {
				even += temp.val;
			} else {
				odd += temp.val;
			}

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}

		}

		return odd - even;
	}
}
