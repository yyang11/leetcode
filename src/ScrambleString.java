

import java.util.Arrays;

/**
 * rgtae is scrambel string of great, so eatgr is scramble string of great
 * thus the result is isScramble(s1, s2) || isScramble(s1, s2.reverse())
 */
public class ScrambleString {
	//non-dp version
    public boolean isScramble(String s1, String s2) {
    	if(s1==null || s2==null || s1.length()!=s2.length()) 
    		return false;
    	if(s1.equals(s2))
    		return true;
    	char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) 
        	return false;
    	for(int i=1; i<s1.length(); i++) {
    		if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
    			return true;
    		if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
    			return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		boolean result = new ScrambleString().isScramble("hobobyrqd", "hbyorqdbo");
		System.out.println(result);
	}
}