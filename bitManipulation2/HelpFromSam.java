package bitManipulation2;

public class HelpFromSam {

	public int solve(int A) {

		int count = 0;

		while (A != 0) {
			count += ((A & 1) == 1) ? 1 : 0;
			A = A >> 1;
		}

		return count;
	}

}
