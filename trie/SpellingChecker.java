package trie;

import java.util.ArrayList;
import java.util.HashMap;


/*
 * Problem Description
Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.



Problem Constraints
1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000



Input Format
First argument is array of strings A.

First argument is array of strings B.



Output Format
Return the binary array of integers according to the given format.



Example Input
Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]


Example Output
Output 1:

[1, 0]
Output 2:

[0, 0]


Example Explanation
Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.
*/

public class SpellingChecker {
	class Trie {
		HashMap<Character, Trie> map;
		boolean eow = false;

		Trie() {
			this.map = new HashMap<>();
			this.eow = false;
		}
	}

	public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {

		Trie node = new Trie();

		for (String str : A) {
			// read word
			insertWords(node, str);
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (String str : B) {
			if (search(node, str)) {
				ans.add(1);
			} else {
				ans.add(0);
			}
		}

		return ans;
	}

	public void insertWords(Trie root, String word) {
		Trie curr = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.map.containsKey(ch)) {
				curr = curr.map.get(ch);
			} else {
				Trie node = new Trie();
				curr.map.put(ch, node);
				curr = curr.map.get(ch);
			}
		}

		curr.eow = true;
	}

	public boolean search(Trie root, String word) {
		Trie curr = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (curr.map.containsKey(ch)) {
				curr = curr.map.get(ch);
			} else {
				return false;
			}
		}

		if (curr.eow) {
			return true;
		}

		return false;
	}
}
