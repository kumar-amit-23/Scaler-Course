package carryForward;

public class SpecialSubsequencesAG {
	public int solve(String A) {

		int acount = 0;
		int total = 0;
		int modulo = (int) Math.pow(10, 9) + 7;
		for (char ch : A.toCharArray()) {
			if (ch == 'A')
				acount++;
			else if (ch == 'G')
				total += acount;
		}

		return total % modulo;

	}

}
