package stringPatternMatching;

import java.util.HashMap;

/*
 * Problem Description
You are given a string A. Find the number of substrings that start and end with 'a'.



Problem Constraints
1 <= |A| <= 105

The string will have only lowercase English letters.



Input Format
Given the only argument is a String A.



Output Format
Return number of substrings that start and end with 'a'.



Example Input
Input 1:

 A = "aab"
Input 2:

 A = "bcbc"


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 Substrings that start and end with 'a' are:
    1. "a"
    2. "aa"
    3. "a"
Explanation 2:

 There are no substrings that start and end with 'a'.
*/
public class CountA {
	public int solve(String A) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		for (char ch : A.toCharArray()) {
			if (ch == 'a') {
				count++;
				count += map.get(ch);
				map.put(ch, map.get(ch) + 1);
			}
		}

		return count;
	}
}
