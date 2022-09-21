package carryForward;

public class EvenSubarrays {
	public String solve(int[] a) {
		if (a.length % 2 != 0 || a[0] % 2 != 0 || a[a.length - 1] % 2 != 0)
			return "NO";

		else
			return "YES";
	}
}
