package stringPatternMatching;

/*
 * Problem Description
You are given two strings, A and B, of size N and M, respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two arguments, A and B of type String.



Output Format
Return a single integer, i.e., number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
*/
public class PermutationOfAandB {

	public int solve(String A, String B) {

		int[] a = new int[26];
		for (int i = 0; i < A.length(); i++) {
			a[A.charAt(i) - 'a']++;
		}

		int l = 0;
		int r = 0;
		int ans = 0;
		int[] b = new int[26];

		for (int i = 0; i < B.length(); i++) {
			b[B.charAt(r) - 'a']++;
			if ((r - l + 1) == A.length()) {
				boolean check = true;
				for (int j = 0; j < 26; j++) {
					if (a[j] != b[j]) {
						check = false;
						break;
					}
				}

				if (check) {
					ans++;
				}

				b[B.charAt(l) - 'a']--;
				l++;
			}
			r++;
		}

		return ans;
	}

}
