package stringPatternMatching;

/*
 * Problem Description

Given two strings A and B. Check if B contains same characters as that of given string A and in the same order.


Problem Constraints

1: A and B contain only UPPERCASE Letters.
2: No two consecutive characters are same in A.
3: You can only use constant amount of extra memory.


Input Format

The first argument given is string A.
The second argument given is string B.


Output Format

Return 1 if B contains same characters as that of given string A and in the same order else return 0.


Example Input

Input 1:
    A = "HIRED" 
    B = "HHHIIIRRRRREEEEEDDDDD"
Input 2:

    A = "HIRED"
    B = "DDHHHHIIIIRRRRREEEEDDD"


Example Output

Output 1:
    1
Output 2:

    0


Example Explanation

Explanation 1:
    B has same characters and appear in same order.
Explanation 2:

    B has extra character "D"
*/
public class SameFormatString {
	public int solve(final String A, final String B) {

		if (A.length() > B.length()) {
			return 0;
		}

		if (A.charAt(0) != B.charAt(0)) {
			return 0;
		}

		int i = 0;
		int j = 0;
		boolean check;
		while (i < A.length() && j < B.length()) {
			check = false;

			if (A.charAt(i) == B.charAt(j)) {
				j++;
				check = true;
			}

			if (!check) {
				i++;
				if (i < A.length() && A.charAt(i) == B.charAt(j)) {
					j++;
				} else {
					return 0;
				}
			}

		}

		if (i != A.length() - 1) {
			return 0;
		}
		return 1;
	}
}


//Scaler Solution :-
/*
 * public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final String A, final String B) {
            int i = 0 , j = 0;
    int n = A.length();
    int m = B.length();

    while( i < n)
    {
        int count = 0;
        
        // count how many times the current character is available in string B
        
        while(j < m && B.charAt(j) == A.charAt(i))
        {
            count++;
            j++;
        }
        
        // if count does not greater than one, return unmatched
        
        if(count == 0)
            return 0;
        
        i++;
    }
    
    // here we are checking whether the strings have been completely used up or not 
    if(i != n || j != m)
        return 0;
    
    return 1;
    }
}
 */
