package introToArray;

import java.util.Scanner;

public class SearchElement {
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner scn = new Scanner(System.in);
		int test_case = scn.nextInt();

		while (test_case-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			int target = scn.nextInt();
			boolean flag = false;
			for (int num : arr) {
				if (num == target) {
					flag = true;
					break;
				}
			}
			if (flag) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		}
		scn.close();

	}

}
