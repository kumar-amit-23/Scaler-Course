package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/*
 * Problem Description
Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.

Return the array A after sorting from the above method.

NOTE: Elements of B are unique.



Problem Constraints
1 <= length of the array A <= 100000

1 <= length of the array B <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is the integer array B.



Output Format
Return the array A after sorting as described.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:

A = [5, 17, 100, 11]
B = [1, 100]


Example Output
Output 1:

[5, 4, 2, 1, 3]
Output 2:

[100, 5, 11, 17]


Example Explanation
Explanation 1:

 Simply sort as described.
Explanation 2:

 Simply sort as described.
*/public class SortArrayingivenOrder {
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		Collections.sort(A);

		HashMap<Integer, Integer> mapA = new HashMap<>();
		for (int num : A)
			mapA.put(num, mapA.getOrDefault(num, 0) + 1);

		HashMap<Integer, Integer> mapB = new HashMap<>();
		for (int num : B) {
			mapB.put(num, mapA.getOrDefault(num, 0) + 1);
		}
		ArrayList<Integer> ans = new ArrayList<>();

		for (int num : B) {
			if (mapA.containsKey(num)) {
				for (int i = 0; i < mapA.get(num); i++) {
					ans.add(num);
				}
			}
		}

		ArrayList<Integer> temp = new ArrayList<>();

		for (int num : A) {
			if (!mapB.containsKey(num)) {
				temp.add(num);
			}
		}

		for (int num : temp)
			ans.add(num);
		return ans;
	}

}
