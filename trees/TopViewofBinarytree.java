package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the top view of the binary tree.



Example Input
Input 1:

 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:

 
            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

Top view is described.
Explanation 2:

Top view is described.
*/
public class TopViewofBinarytree {
	class Pair {
		TreeNode node;
		int level;

		Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public ArrayList<Integer> solve(TreeNode A) {
		int min = 0;
		int max = 0;

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		Queue<Pair> queue = new LinkedList<>();
		Pair p = new Pair(A, 0);
		queue.add(p);

		while (!queue.isEmpty()) {
			Pair temp = queue.poll();

			if (map.containsKey(temp.level)) {
				ArrayList<Integer> list = map.get(temp.level);
				list.add(temp.node.val);
				map.put(temp.level, list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(temp.node.val);
				map.put(temp.level, list);
			}

			if (temp.node.left != null) {
				min = Math.min(min, temp.level - 1);
				p = new Pair(temp.node.left, temp.level - 1);
				queue.add(p);
			}

			if (temp.node.right != null) {
				max = Math.max(max, temp.level + 1);
				p = new Pair(temp.node.right, temp.level + 1);
				queue.add(p);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i >= min; i--) {
			ans.add(map.get(i).get(0));
		}
		for (int i = 1; i <= max; i++) {
			ans.add(map.get(i).get(0));
		}

		return ans;

	}

}
