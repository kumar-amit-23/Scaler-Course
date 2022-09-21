package stack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		ArrayList<Integer> lst = new ArrayList<>();
		lst.add(2);
		lst.add(1);
		lst.add(5);
		lst.add(6);
		lst.add(2);
		lst.add(3);

	}

	public static int largestRectangleArea(ArrayList<Integer> A) {

		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> lsa = new ArrayList<>();

		// constructing left smallest ArrayList

		for (int i = 0; i < A.size(); i++) {
			if (stack.isEmpty()) {
				lsa.add(-1);
				stack.push(i);
			} else {
				if (A.get(stack.peek()) < A.get(i)) {
					lsa.add(stack.peek());
					stack.push(i);
				} else {
					while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						lsa.add(-1);
						stack.push(i);
					} else {
						lsa.add(stack.peek());
						stack.push(i);

					}
				}
			}
		}

		// constructing right smallest ArrayList
		ArrayList<Integer> rsa = new ArrayList<>();
		for (int i = A.size() - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				rsa.add(A.size());
				stack.push(i);
			} else {
				if (A.get(stack.peek()) < A.get(i)) {
					rsa.add(stack.peek());
					stack.push(i);
				} else {
					while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						rsa.add(A.size());
						stack.push(i);
					} else {
						rsa.add(stack.peek());
						stack.push(i);

					}
				}
			}
		}
		int area = 0;
		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			area = (lsa.get(i) + 1 + rsa.get(i) - 1 + 1) * A.get(i);
			max = Math.max(area, max);
		}

		return max;

	}

}
