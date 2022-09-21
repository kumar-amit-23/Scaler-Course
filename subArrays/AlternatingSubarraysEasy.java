package subArrays;

import java.util.ArrayList;

public class AlternatingSubarraysEasy {

	public static ArrayList<Integer> solve2(ArrayList<Integer> A, int B) {

		int k = 2 * B + 1;
		System.out.println(1/2);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = k / 2; i <= A.size() - k / 2 - 1; i++) {
			Boolean flag = true;
			for (int j = i - 1; j >= i - k / 2; j--) {
				if (A.get(j + 1) == A.get(j)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				for (int j = i + 1; j <= i + k / 2; j++) {
					if (A.get(j - 1) == A.get(j)) {
						flag = false;
						break;
					}
				}
			}

			if (flag) {
				System.out.println(i);
				list.add(i);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
//		list.add(1);
//		list.add(0);
//		list.add(0);
//		list.add(0);
//		list.add(1);
//		list.add(0);
//		list.add(1);
//		list.add(1);
		
		solve2(list, 0);
	}

}
