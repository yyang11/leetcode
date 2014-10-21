
/**
 * 连续的重复字符会产生迭代分支，需要dp
 * ugly
 */
public class InterleavingString {
	int[][] dp;
	final int NULL = 0, TRUE = 1, FALSE = 2;
	
	public boolean isInterleave(String s1, String s2, String s3) {
		dp = new int[s1.length() + 2][s2.length() + 2];
		return isInterleave(s1, 0, s2, 0, s3);
    }
	
	public boolean isInterleave(String s1, int n1, String s2, int n2, String s3) {
		if(dp[n1][n2] == NULL) {
			int n3 = n1 + n2;
			if(s3.length() == n3)
				dp[n1][n2] = s1.length() == n1 && s2.length() == n2 ? TRUE : FALSE;
			else {
				char ch = s3.charAt(n3);
				if(s1.length() == n1 || s1.charAt(n1) != ch)
					dp[n1][n2] =  s2.length() != n2 && s2.charAt(n2) == ch && isInterleave(s1, n1, s2, n2 + 1, s3) ? TRUE : FALSE;
				else if(s2.length() == n2 || s2.charAt(n2) != ch)
					dp[n1][n2] =  s1.charAt(n1) == ch && isInterleave(s1, n1 + 1, s2, n2, s3) ? TRUE : FALSE;
				else
					dp[n1][n2] =  isInterleave(s1, n1 + 1, s2, n2, s3) || isInterleave(s1, n1, s2, n2 + 1, s3) ? TRUE : FALSE;
				}
		}
		return dp[n1][n2] == TRUE;
	}
	
	public static void main(String[] args) {
		boolean result = new InterleavingString().isInterleave("aabbbbbbbbbbbbbbbbbbcc", "dbbbbbbbbbbbbbbbbbbca", "aadbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaccc");
		System.out.println(result);
	}
}