package bitManipulation1;

public class AddBinaryStrings {

	public static String addBinary(String A, String B) {

		StringBuilder str = new StringBuilder();
		int i = A.length() - 1;
		int j = B.length() - 1;
		int s = 0;

		while (i >= 0 || j >= 0 || s == 1) {
			s += (i >= 0) ? A.charAt(i) - '0' : 0;
			s += (j >= 0) ? B.charAt(j) - '0' : 0;

			str.append((char) (s % 2 + '0'));
			s /= 2;
			i--;
			j--;
		}

		int start = str.length() - 1;
		while (start >= 0 && str.charAt(start) == 0) {
			start--;
		}

		if (start != str.length() - 1) {
			str.delete(start, str.length() - 1);
		}

		return str.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("1010110111001101101000","1000011011000000111100110"));
	}

}
