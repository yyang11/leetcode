package done;

//two pointer
//if there were no duplicated char in T, hashtable would be enough
public class MinimumWindowSubstring {
  public String minWindow(String S, String T) {
    int[] src=new int[128],dest=new int[128];
    for(char ch:T.toCharArray())
      src[ch]++;
    int begin=-1,end=-1,minLen=S.length()+1;
    int enough=0;
    int fp=0;
    for(int i=0;i<S.length();i++) {
      char ch=S.charAt(i);
      if(src[ch]!=0) {
        dest[ch]++;
        if(dest[ch]<=src[ch])
          enough++;
        if(enough>=T.length()) {
          //shrink
          while(fp<i&&(src[S.charAt(fp)]==0||(--dest[S.charAt(fp)]>=src[S.charAt(fp)])))
            fp++;
          if(minLen>i-fp+1) {
            minLen=i-fp+1;
            begin=fp;
            end=i;
          }
          fp++;
          enough--;
        }
      }
    }
    if(begin<0)
      return "";
    return S.substring(begin, end+1);
  }

  public static void main(String args[]) {
    String S="ADOBECODEBANC";
    String T="ABC";
    System.out.println(new MinimumWindowSubstring().minWindow(S, T));
  }
}
