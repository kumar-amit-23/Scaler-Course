package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(A);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (curr == null) {
				ans.add(-1);
				continue;
			}

			ans.add(curr.val);
			queue.add(curr.left);
			queue.add(curr.right);
		}

		return ans;
	}
}
