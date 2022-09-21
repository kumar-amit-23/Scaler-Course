package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).



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
   [20, 9],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [2, 6]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the zigzag traversal of each level.

*/
public class ZigZagLevelTraversalOrder {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(A);
        queue.add(null);
        int check = 1;

		while (queue.size() > 1) {
			TreeNode temp = queue.poll();

			if (temp == null) {
				if (check == 1) {
					Collections.reverse(level);
				}
				ans.add(level);
				level = new ArrayList<>();
				queue.add(null);
				check = (check == 1) ? 0 : 1;
				continue;
			}

			level.add(temp.val);

			if (temp.right != null) {
				queue.add(temp.right);
			}

			if (temp.left != null) {
				queue.add(temp.left);
			}

		}
        
        if (check == 1) {
			Collections.reverse(level);
		}
		
        ans.add(level);

        return ans;
	}
}
