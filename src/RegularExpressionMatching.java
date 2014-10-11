

/**
 * Crazy driving problem
 */
public class RegularExpressionMatching {
	private final int NULL = 0;
	private final int TRUE = 1;
	private final int FALSE = 2;
	private int[][] dp;
	
    public boolean isMatch(String s, String p) {
    	dp = new int[s.length() + 1][p.length() + 1];
    	return doMatch(s, 0, p, 0);
    }
	
    private boolean doMatch(String s, int m, String p, int n) {
    	if(dp[m][n] != NULL)
    		return dp[m][n] == TRUE;
    	if(s.length()==m) {
    		if(p.length()==n)
    			return setDP(true, m, n);
    		if(p.length()==n+1 || p.charAt(n+1)!='*')
    			return setDP(false, m, n);
    		return setDP(doMatch(s, m, p, n + 2), m, n);
    	}
    	if(p.length()==n)
    		return setDP(false, m, n);
    	
    	//p=X*
    	if(p.length()>n + 1 && p.charAt(n + 1)=='*') {
    		boolean ignoreStar = doMatch(s, m, p, n + 2);
    		boolean normalStar = false;
    		if(p.charAt(n)=='.' || s.charAt(m)==p.charAt(n))
    			normalStar = doMatch(s, m + 1, p, n);
    		return setDP(ignoreStar || normalStar, m, n);
    	}
    	else {
    		if(p.charAt(n)=='.' || s.charAt(m)==p.charAt(n))
    			return setDP(doMatch(s, m + 1, p, n + 1), m, n);
    		else
    			return setDP(false, m, n);
    	}
    }
    
    private boolean setDP(boolean boolResult, int m, int n) {
    	int intRes = boolResult ? TRUE : FALSE;
    	dp[m][n] = intRes;
    	return boolResult;
    }
    
    public static void main(String[] args) {
    	String s = "abcdede";
    	String p = "ab.*de";
    	boolean result = new RegularExpressionMatching().isMatch(s, p);
    	System.out.println(result);
	}
}
