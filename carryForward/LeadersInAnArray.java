package carryForward;

import java.util.HashSet;

public class LeadersInAnArray {

	public int[] solve(int[] A) {

		HashSet<Integer> list = new HashSet<>();

		int[] postmax = new int[A.length];

		postmax[A.length - 1] = A[A.length - 1];

		for (int i = A.length - 2; i >= 0; i--) {
			postmax[i] = Math.max(A[i], postmax[i + 1]);
		}

		for (int i = 0; i < postmax.length; i++) {
			list.add(postmax[i]);
		}

		int[] ans = new int[list.size()];
		int index = 0;
		for (int num : list) {
			ans[index++] = num;
		}

		return ans;
	}

}
