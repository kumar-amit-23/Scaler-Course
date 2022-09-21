package introToArray;

import java.util.Scanner;

public class MaxAndMinofArray {
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int num : arr) {
			if (num > max) {
				max = num;
			}

			if (num < min) {
				min = num;
			}
		}

		System.out.print(max + " " + min);
		scn.close();
	}
}
