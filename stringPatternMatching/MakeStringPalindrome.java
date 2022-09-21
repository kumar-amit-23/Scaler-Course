package stringPatternMatching;

/*
 * Problem Description
Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.



Problem Constraints
1 <= N <= 106



Input Format
The only argument given is a string A.



Output Format
Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.



Example Input
Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome. 
*/
public class MakeStringPalindrome {

	public int solve(String A) {

		// construct LPS array
		String str = A + "$" + reverse(A);
		int[] lps = new int[str.length()];

		lps[0] = 0;
		int x;
		for (int i = 1; i < lps.length; i++) {
			x = lps[i - 1];

			while (str.charAt(x) != str.charAt(i)) {
				if (x == 0) {
					x = -1;
					break;
				}

				x = lps[x - 1];
			}

			lps[i] = x + 1;
		}

		return A.length() - lps[lps.length - 1];
	}

	public String reverse(String s) {
		int i = 0;
		int j = s.length() - 1;
		char[] ch = s.toCharArray();

		while (i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}

		return new String(ch);
	}

}
