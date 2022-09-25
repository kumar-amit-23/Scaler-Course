package trie;

import java.util.ArrayList;

public class MaximumXOR {
	class TrieNode {
		TrieNode[] arr;

		TrieNode() {
			this.arr = new TrieNode[2];
		}
	}

	public int solve(ArrayList<Integer> A) {

		TrieNode root = new TrieNode();

		insert(root, A.get(0));
		
		int ans = 0;
		
		for (int i = 1; i < A.size(); i++) {
			ans = Math.max(ans, findXor(root, A.get(i)));
			insert(root, A.get(i));
		}

		return ans;
	}

	public int findXor(TrieNode root, int num) {
		TrieNode curr = root;

		int ans = 0;

		for (int i = 31; i >= 0; i--) {
			int bit = num & (1 << i);
			int cbit = bit ^ 1;

			if (curr.arr[cbit] != null) {
				ans += (1 << i);
				curr = curr.arr[cbit];
			} else {
				curr = curr.arr[bit];
			}
		}

		return ans;
	}

	void insert(TrieNode root, int num) {
		TrieNode curr = root;

		for (int i = 31; i >= 0; i--) {
			int bit = (num & (1 << i));

			if (curr.arr[bit] == null) {
				curr.arr[bit] = new TrieNode();
			}

			curr = curr.arr[bit];
		}
	}
}
