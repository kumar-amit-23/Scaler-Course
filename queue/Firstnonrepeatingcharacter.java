package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Firstnonrepeatingcharacter {
	public String solve(String A) {
		HashMap<Character, Integer> map = new HashMap<>();
		Deque<Character> deque = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();
		for (char ch : A.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			deque.add(ch);

			while (!deque.isEmpty() && map.get(deque.peekFirst()) > 1) {
				deque.removeFirst();
			}

			if (!deque.isEmpty()) {
				sb.append(deque.peekFirst());
			} else {
				sb.append('#');
			}
		}

		return sb.toString();
	}
}
