
/**
 * 赤裸裸的歧视啊，同样的代码C++跑得过，Java死活跑不过
 */
public class WildcardMatching {
	boolean[][] dp = new boolean[1000][500];
	public boolean isMatch(String s, String p) {
		dp[0][0] = true;
		for(int i=1; i<p.length()&&p.charAt(i-1)=='*'; i++)
			dp[0][i] = true;
		for(int i=1; i<=s.length(); i++) {
			for(int j=1; j<=p.length(); j++) {
				if(p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				else if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
				else dp[i][j] = false;
			}
		}
		return dp[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "a*a*b*";
		boolean result = new WildcardMatching().isMatch(s, p);
		System.out.println(result);
	}
}
