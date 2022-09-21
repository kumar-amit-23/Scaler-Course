package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
	class Pair {
		int data;
		int indx;

		Pair(int data, int indx) {
			this.data = data;
			this.indx = indx;
		}
	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList<>();

		Deque<Pair> deque = new ArrayDeque<>();

		for (int i = 0; i < B; i++) {

			while (!deque.isEmpty() && deque.peekLast().data < A.get(i)) {
				deque.removeLast();
			}
			Pair p = new Pair(A.get(i), i);
			deque.add(p);
		}

		ans.add(deque.peekFirst().data);
		if (deque.peekFirst().data == A.get(0) && deque.peekFirst().indx == 0) {
			deque.removeFirst();
		}

		for (int i = B; i < A.size(); i++) {
			while (!deque.isEmpty() && deque.peekLast().data < A.get(i)) {
				deque.removeLast();
			}

			Pair p = new Pair(A.get(i), i);
			deque.add(p);

			if (deque.peekFirst().data == A.get(i - B) && deque.peekFirst().indx == (i - B)) {
				deque.removeFirst();
			}

			ans.add(deque.peekFirst().data);
		}

		return ans;
	}
}
