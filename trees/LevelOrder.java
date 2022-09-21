package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
*/
public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> level = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (A == null)
			return null;
		queue.add(A);
		queue.add(null);
		TreeNode node;
		while (!queue.isEmpty()) {
			node = queue.remove();
			if (node == null && queue.isEmpty()) {
				res.add(new ArrayList<>(level));
				break;
			}
			if (node == null) {
				res.add(new ArrayList<>(level));
				level.clear();
				queue.add(null);
				continue;
			}
			level.add(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return res;
	}

}
