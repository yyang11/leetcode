import java.util.HashSet;
import java.util.Set;

/**
 * dp solution
 */
public class WordBreak {
  private boolean[] dp;
  public boolean wordBreak(String s, Set<String> dict) {
    dp = new boolean[s.length() + 1];
    dp[s.length()] = true;
    for(int i = s.length() - 1; i>=0; i--) {
      for(String word : dict) {
        if (s.startsWith(word, i) && dp[i + word.length()]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }

  public static void main(String args[]) {
    Set<String> dict = new HashSet<String>();
    dict.add("leet");
    dict.add("code");
    boolean result = new WordBreak().wordBreak("leetcode", dict);
    System.out.println(result);
  }
}
