package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000



Input Format
The only argument given is an integer A.



Output Format
Return a string that denotes the Ath Perfect Number.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 22
Output 2:

 1111


Example Explanation
Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
*/
public class PerfectNumbers {
	public String solve(int A) {
		Queue<String> q = new LinkedList<>();
		q.add("11");
		q.add("22");

		while (A - 1 != 0) {
			String var = q.peek();
			int size = var.length();
			String s1 = var.substring(0, size / 2);
			String s2 = var.substring(size / 2, size);

			q.add(s1 + "11" + s2);
			q.add(s1 + "22" + s2);

			q.remove();
			A--;

		}

		return q.peek();
	}
}
