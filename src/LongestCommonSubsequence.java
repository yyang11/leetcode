
 
public class LongestCommonSubsequence {
      public String lcs(char[] a, char[] b) {
            int[][] lengths = new int[a.length+1][b.length+1];
            for (int i = 0; i < a.length; i++) {
                  for (int j = 0; j < b.length; j++) {
                        if(a[i] == b[j])
                              lengths[i+1][j+1] = lengths[i][j] + 1;
                        else
                              lengths[i+1][j+1] = Math.max(lengths[i][j+1], lengths[i+1][j]);
                  }
            }
            StringBuilder str = new StringBuilder();
            for(int i=a.length,j=b.length; i>0 && j>0;) {
                  if(lengths[i][j] == lengths[i-1][j]) {
                        i--;
                  }
                  else if(lengths[i][j] == lengths[i][j-1]) {
                        j--;
                  }
                  else {
                        if(a[i-1] != b[j-1])
                              System.err.println("length matrix error!");
                        str.append(a[i-1]);
                        i--;
                        j--;
                  }
            }
            return str.reverse().toString();
      }
}