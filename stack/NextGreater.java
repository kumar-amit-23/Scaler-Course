package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreater {
	public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = A.size() - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				list.add(-1);
				stack.push(A.get(i));
			} else {
				if (stack.peek() > A.get(i)) {
					list.add(stack.peek());
					stack.push(A.get(i));
				} else {
					while (!stack.isEmpty() && stack.peek() <= A.get(i)) {
						stack.pop();
					}

					if (stack.isEmpty()) {
						stack.push(A.get(i));
						list.add(-1);
					} else {
						list.add(stack.peek());
						stack.push(A.get(i));
					}
				}
			}
		}

		Collections.reverse(list);

		return list;
	}
}
