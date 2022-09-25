package trees;

import java.util.ArrayList;

public class NodedistanceCinbinarytree {
	ArrayList<TreeNode> list = new ArrayList<>();
	ArrayList<Integer> ans = new ArrayList<>();

	public ArrayList<Integer> solve(TreeNode A, int B, int C) {
		ArrayList<Integer> ans2 = new ArrayList<>();
		findNodePath(A, B);

		findNodeAtKdistance(list.get(0), C);

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).left == list.get(i - 1)) {
				findNodeAtKdistance(list.get(i).right, C - i - 1);
			} else {
				findNodeAtKdistance(list.get(i).left, C - i - 1);
			}
		}

		for (int i = 1; i < list.size(); i++) {
			if (i == C) {
				ans.add(list.get(i).val);
			}
		}

		for (int num : ans) {
			ans2.add(num);
		}

		return ans2;
	}

	public int findNodeAtKdistance(TreeNode A, int k) {
		if (A == null) {
			return 0;
		}

		if (k < 0)
			return 0;

		if (k == 0) {
			ans.add(A.val);
			return 1;
		}

		int left = findNodeAtKdistance(A.left, k - 1);
		int right = findNodeAtKdistance(A.right, k - 1);

		return left + right;
	}

	public boolean findNodePath(TreeNode A, int B) {
		if (A == null)
			return false;

		if (A.val == B) {
			list.add(A);
			return true;
		}

		boolean left = findNodePath(A.left, B);
		boolean right = findNodePath(A.right, B);

		if (left || right) {
			list.add(A);
			return true;
		}

		return false;
	}
}
