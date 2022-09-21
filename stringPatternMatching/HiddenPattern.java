package stringPatternMatching;

/*
 * Problem Description

Given two strings - a text A and a pattern B, having lower-case alphabetic characters. You have to determine the number of occurrences of pattern B in text A as its substring. i.e. the number of times B occurs as a substring in A.



Problem Constraints

1 <= |B| <= |A| <= 105



Input Format

First argument is a string A

Second argument is a string B



Output Format

Return the number of occurrences.



Example Input

Input 1:

 A = "abababa"
 B = "aba" 
Input 2:

 A = "mississipi"
 B = "ss" 
Input 3:

 A = "hello" 
 B = "hi" 


Example Output

Output 1:

 3 
Output 2:

 2 
Output 3:

 0 


Example Explanation

Explanation 1:

 A has 3 substrings equal to B - A[1, 3], A[3, 5] and A[5, 7] 
Explanation 2:

 B occurs two times in A - A[3, 4], A[6, 7]. 
Explanation 3:

 B does not occur in A as a substring. 
*/
public class HiddenPattern {
	public int solve(final String A, final String B) {

		// construct LPS array
		String str = B + "$" + A;
		int[] LPS = new int[str.length()];
		LPS[0] = 0;
		int x;
		int count = 0;
		for (int i = 1; i < LPS.length; i++) {
			x = LPS[i - 1];

			while (str.charAt(x) != str.charAt(i)) {
				if (x == 0) {
					x = -1;
					break;
				}

				x = LPS[x - 1];
			}

			LPS[i] = x + 1;
			
			if (LPS[i] == B.length()) {
				count++;
			}

		}

		return count;

	}
}
