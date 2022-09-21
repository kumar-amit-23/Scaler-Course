package bitManipulation1;

public class ReverseBits {

	public long reverse(long a) {
		long num = 0;
		
		
		String str = "";
		
		while(a != 0) {
			str += (a/2);
			a = a/2;
		}
		
		return num;
		
	}

}
