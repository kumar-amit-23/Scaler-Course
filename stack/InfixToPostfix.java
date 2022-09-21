package stack;

import java.util.Stack;

/*
 * Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints
1 <= length of the string <= 500000



Input Format
The only argument given is string A.



Output Format
Return a string denoting the postfix conversion of A.



Example Input
Input 1:

 A = "x^y/(a*z)+b"
Input 2:

 A = "a+b*(c^d-e)^(f+g*h)-i"


Example Output
Output 1:

 "xy^azb+"
Output 2:

 "abcd^e-fgh*+^*+i-"


Example Explanation
Explanation 1:

 Ouput dentotes the postfix expression of the given input.*/

public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(solve("a*(r+o*h)"));
	}

	public static String solve(String A) {

		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < A.length(); i++) {

			char ch = A.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				sb.append(ch);
			else {

				if (stack.isEmpty())
					stack.push(ch);
				else {
					if (ch == '(')
						stack.push(ch);
					else if (ch == ')') {
						while (!stack.isEmpty() && stack.peek() != '(')
							sb.append(stack.pop());
						stack.pop();
					} else {
						while (!stack.isEmpty() && stack.peek() != '('
								&& checkPriority(stack.peek()) >= checkPriority(ch))
							sb.append(stack.pop());
						stack.push(ch);
					}
				}
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

	public static int checkPriority(char op) {

		if (op == '^')
			return 3;
		else if (op == '/' || op == '*')
			return 2;
		return 1;
	}

}
