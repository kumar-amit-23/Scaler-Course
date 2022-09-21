package stringPatternMatching;

/*
 * Problem Description
You are given a family of strings. Where S0 = "0". Each successive string is derived from previous string using the following recursive relation.

Si = Si-1 + "0" + (Si-1)'. Where (S)' means compliment of that string.

For example:

S0 = "0"
S1 = "001"
S2 = "0010110"
....
Given A and B your task is to find the Bth character in SA.
Note: B is 0 based indexing


Problem Constraints
0 <= A <= 50

0 <= K <= min(109,2(A+1)-2))


Input Format
First argument contains integer A

Second argument contains integer B


Output Format
Return a single integer 0 or 1 to answer the question.


Example Input
Input1:
A = 2
B = 3

Input2:

A = 3
B = 4


Example Output
Output1:
    0

Output2:

    1


Example Explanation
Explaination1:
S2 = "0010110"
Hence using 0 based indexing S2[3] = "0"

Explaination2:

S3 = "001011001101001"
Hence using 0 based indexing S2[4] = "1"
*/
public class FamilyOfStrings {

	// Aproach - Brute force
	public int solve(int A, int B) {

		int i = 0;
		String str = "";
		while (i < A + 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.append('0');
			sb.append(flip(str));
			str = sb.toString();
			i++;
		}

		return str.charAt(B) - '0';
	}

	public String flip(String str) {
		if (str.length() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == '0') {
				sb.append('1');
			} else {
				sb.append('0');
			}
		}

		return sb.toString();
	}

}
