//there is another solution cost O(n) time and O(n) space
//http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html

public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        int maxlen=0, start=0;
        for(int i=0;i<s.length();i++) {
            int len=1;
            //odd
            for(int j=1;i-j>=0&&i+j<s.length()&&s.charAt(i-j)==s.charAt(i+j);j++,len+=2);
            if(len>maxlen) {
                maxlen=len;
                start=i-len/2;
            }
            //even
            len=0;
            for(int j=0;i-j>=0&&i+j+1<s.length()&&s.charAt(i-j)==s.charAt(i+j+1);j++,len+=2);
            if(len>maxlen) {
                maxlen=len;
                start=i-len/2+1;
            }
        }
        return s.substring(start,start+maxlen);
    }
}
