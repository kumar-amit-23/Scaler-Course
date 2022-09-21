package subArrays;

public class MaxSumContiguousSubarray {

	public int maxSubArray(final int[] A) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<A.length; i++) {
			for(int j = i+1 ; j<A.length; j++) {
				sum += A[j];
				if(sum > max)
					max = sum;
			}
		}
		
		return sum;
	}

}
