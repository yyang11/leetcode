import java.util.*;

/**
 * dp[i]是s.subString(i)的word break的第一个单词长度链表
 */
public class WordBreakII {
  List<Integer> dp[];

  public List<String> wordBreak(String s, Set<String> dict) {
    dp = new List[s.length() + 1];
    dp[s.length()] = new ArrayList<Integer>();
    for(int i=s.length()-1; i>=0; i--) {
      for(String word : dict) {
        if (s.startsWith(word, i) && dp[i + word.length()] != null) {
          if(dp[i] == null)
            dp[i] = new ArrayList<Integer>();
          dp[i].add(word.length());
        }
      }
    }
    List<String> res = new LinkedList<String>();
    collect(s, 0, "", res);
    return res;
  }

  void collect(String s, int pos, String str, List<String> res) {
    if(dp[pos] == null)
      return;
    if(pos == s.length()) {
      res.add(str.trim());
      return;
    }
    for(Integer i : dp[pos]) {
      collect(s, pos + i, str + " " + s.substring(pos, pos + i), res);
    }
  }

  public static void main(String args[]) {
    String s = "catsanddog";
    Set<String> dict = new HashSet<String>();
    dict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
    List<String> result = new WordBreakII().wordBreak(s, dict);
    System.out.println(result);
  }
}
