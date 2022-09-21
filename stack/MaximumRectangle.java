package stack;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumRectangle {
	public int solve(ArrayList<ArrayList<Integer>> A) {

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++) {
				stack.push(A.get(i).get(j));
			}
		}
		int area = 0;
		int count = 0;
		while (!stack.isEmpty()) {
			while (!stack.isEmpty() && stack.peek() == 0) {
				stack.pop();
			}

			while (!stack.isEmpty() && stack.peek() == 1) {
				count++;
				stack.pop();
			}

			if (count > 0) {
				int height = count / A.get(0).size();
				int width = count;

				if (A.get(0).size() * height < count) {
					width = count - A.get(0).size() * height;
					height++;
				}

				area = Math.max(area, width * height);
			}

		}

		return area;
	}

}
