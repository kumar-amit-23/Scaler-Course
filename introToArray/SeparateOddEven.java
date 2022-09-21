package introToArray;

import java.util.ArrayList;
import java.util.Scanner;

public class SeparateOddEven {
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

			ArrayList<Integer> oddlist = new ArrayList<>();
			ArrayList<Integer> evenlist = new ArrayList<>();

			for (int num : arr) {
				if (num % 2 == 0) {
					evenlist.add(num);
				} else {
					oddlist.add(num);
				}
			}
			// System.out.println();
			for (int num : oddlist) {
				System.out.print(num + " ");
			}
			System.out.println();
			for (int num : evenlist) {
				System.out.print(num + " ");
			}
			System.out.println();
			scn.close();

		}

	}

}
