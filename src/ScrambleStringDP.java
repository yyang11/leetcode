

/**
 * 更慢了233
 * dp复杂度为n^4，非dp为3^n
 */
public class ScrambleStringDP {
    public boolean isScramble(String s1, String s2) {
        int len=s1.length();
        boolean[][][] dp = new boolean[100][100][100];
        for (int i=len-1;i>=0;i--)
            for (int j=len-1;j>=0;j--) {
                dp[i][j][1]=(s1.charAt(i)==s2.charAt(j));
                for (int l=2;i+l<=len && j+l<=len;l++) {
                    for (int n=1;n<l;n++) {
                        dp[i][j][l]|=dp[i][j][n]&&dp[i+n][j+n][l-n];
                        dp[i][j][l]|=dp[i][j+l-n][n]&&dp[i+n][j][l-n];
                    }
                }
            }
        return dp[0][0][len];
    }
}
