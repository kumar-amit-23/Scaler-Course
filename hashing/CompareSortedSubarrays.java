package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareSortedSubarrays {
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < B.size(); i++) {
			int l1 = B.get(i).get(0);
			int r1 = B.get(i).get(1);
			int l2 = B.get(i).get(2);
			int r2 = B.get(i).get(3);

			HashMap<Integer, Integer> mapA = new HashMap<>();
			HashMap<Integer, Integer> mapB = new HashMap<>();

			for (int j = l1; j <= r1; j++) {
				mapA.put(A.get(j), mapA.getOrDefault(A.get(j), 0) + 1);
			}

			for (int j = l2; j <= r2; j++) {
				mapB.put(A.get(j), mapA.getOrDefault(A.get(j), 0) + 1);
			}

			if (mapA.equals(mapB)) {
				ans.add(1);
			} else {
				ans.add(0);
			}
		}

		return ans;
	}

	public boolean compareHashMaps(HashMap<Integer, Integer> mapA, HashMap<Integer, Integer> mapB) {
		if (mapA.size() != mapB.size()) {
			return false;
		}
		for (int num : mapA.keySet()) {
			if (mapB.containsKey(num) && mapA.get(num) == mapB.get(num)) {
				continue;
			} else {
				return false;
			}
		}

		for (int num : mapB.keySet()) {
			if (mapA.containsKey(num) && mapA.get(num) == mapB.get(num)) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

}
