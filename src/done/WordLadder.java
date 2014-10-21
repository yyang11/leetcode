import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class WordLadder {
  //BFS: length[word] is the length of ladder from start to word
  public int ladderLength(String start, String end, Set<String> dict) {
    dict.add(end);
    Map<String, Integer> lengths = new HashMap<String, Integer>();
    for(String word : dict) {
      lengths.put(word, 0);
    }
    Queue<String> queue = new LinkedBlockingQueue<String>();
    queue.add(start);
    lengths.put(start, 1);
    while(!queue.isEmpty()) {
      String word = queue.remove();
      for(int i=0; i<word.length(); i++) {
        for(char c=0; c<26; c++) {
          char[] replaced = word.toCharArray();
          replaced[i] = (char) (c + 'a');
          String newWord = new String(replaced);
          if(newWord.equals(end))
            return lengths.get(word) + 1;
          if (dict.contains(newWord) && lengths.get(newWord) == 0) {
            lengths.put(newWord, lengths.get(word) + 1);
            queue.add(newWord);
          }
        }
      }
    }
    return 0;
  }

  public static void main(String args[]) {
    Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
    int result = new WordLadder().ladderLength("hit", "cog", dict);
    System.out.println(result);
  }
}
