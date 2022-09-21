package stack;

import java.util.Stack;

/*
 * Problem Description
Given an expression string A, examine whether the pairs and the orders of �{�,�}�, �(�,�)�, �[�,�]� are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output
Output 1:

 1 
Output 2:

 0 
Output 3:

 1 


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
*/
public class BalancedParanthesis {
	public int solve(String A) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : A.toCharArray()) {
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else if (!stack.isEmpty()) {
				if (ch == '}' && stack.peek() == '{') {
					stack.pop();
				} else if (ch == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (ch == ')' && stack.peek() == '(') {
					stack.pop();
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		}

		return (stack.size() == 0) ? 1 : 0;
	}

}
