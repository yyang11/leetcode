public class DistinctSubsequence {
    /**
     * dp[i][j]表示T[0...i]与S[0...j]的numDistinct
     */
    public int numDistinct(String S, String T) {
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        dp[0][0] = 1;
        for(int j=1; j<=S.length(); j++) {
            dp[0][j] = 1;
        }
            for(int i=1; i<=T.length(); i++) {
            for(int j=1; j<=S.length(); j++) {
                dp[0][j] = 1;
                if(T.charAt(i - 1) != S.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }

    public static void main(String args[]) {
//        String S = "rabbbit";
//        String T = "rabbit";
        String S = "ccc";
        String T = "c";
        int result = new DistinctSubsequence().numDistinct(S, T);
        System.out.println(result);
    }
}
