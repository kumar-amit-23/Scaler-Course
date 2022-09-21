package bitManipulation2;

public class SubarrayswithBitwiseOR1 {
	public static long solve(int A, int[] B) {

		long count = 0;
		for (int i = 0; i < A; i++) {
			long ans = 0;
			for (int j = i; j < A; j++) {
				ans |= B[j];
				if (ans == 1) {
					count++;
				}

			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] B = { 0, 1, 1, 0, 1 };
//		int[] arr = new int[100000];

		System.out.println(solve(5, B));
	}

}
