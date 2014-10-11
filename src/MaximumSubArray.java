

public class MaximumSibArray {
	public int maxSubArray(int[] A) {
		int[] dp = new int[A.length + 1];
		for(int i=A.length-1; i>=0; i--) {
			if (dp[i + 1] > 0) {
				dp[i] = dp[i + 1] + A[i];
			} else {
				dp[i] = A[i];
			}
		}
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++) {
			if(dp[i] > maxSum) {
				maxSum = dp[i];
			}
		}
		return maxSum;
    }
	
	public static void main(String[] args) {
		int[] array = { -1 };
		int result = new MaximumSibArray().maxSubArray(array);
		System.out.println(result);
	}
}
