

public class UniqueBinarySearchTrees {
	int[] dp;	
	public int numTrees(int n) {
		if(dp == null) {
			dp = new int[n + 1];
			dp[0] = 1;
		}
		//is this dp?
		if (dp[n] == 0) {
			int numTrees = 0;
			for (int i=0; i<n; i++) {
				numTrees += numTrees(i) * numTrees(n - 1 - i);
			}
			dp[n] = numTrees;
		}
		return dp[n];
    }
	
	public static void main(String[] args) {
		int result = new UniqueBinarySearchTrees().numTrees(1);
		System.out.println(result);
	}
}