package twoDMatrices;

public class AntiDiagonals {
	public static int[][] diagonal(int[][] A) {

		int[][] ans = new int[A.length + A[0].length - 1][A[0].length];
		int x_index = 0;

		for (int i = 0; i < A[0].length; i++) {
			int x = 0;
			int y = i;
			int y_index = 0;
			while (x < A.length && y >= 0) {
				System.out.print(A[x][y] + " ");
				ans[x_index][y_index] = A[x][y];
				y_index++;
				x++;
				y--;
			}
			x_index++;
			System.out.println();
		}

		for (int i = 1; i < A.length; i++) {
			int x = i;
			int y = A[0].length - 1;
			int y_index = 0;
			while (x < A.length && y >= 0) {
				System.out.print(A[x][y] + " ");
				ans[x_index][y_index] = A[x][y];
				y_index++;
				x++;
				y--;
			}
			x_index++;
			System.out.println();
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr = diagonal(arr1);
		System.out.println("----------ANS-----------");
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
