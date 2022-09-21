package carryForward;

public class AmazingSubarrays {
	public static int solve(String A) {

		int ans = 0;

		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
					|| ch == 'O' || ch == 'U') {
				System.out.println(ch);
				ans = ans + (A.length() - i) + 1;
			}
		}

		return ans;
	}

	public static void main(String[] ans) {
		String s = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";
		solve(s);
	}
}
