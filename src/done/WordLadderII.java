import java.util.*;

/**
 * 实现起来最麻烦的题
 */
public class WordLadderII {
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    Map<String, Queue<String>> adjMap = new HashMap<String, Queue<String>>();
    Set<String> visited = new HashSet<String>();
    Set<String> unvisited = new HashSet<String>(dict);
    unvisited.add(end);
    Queue<String> queue = new LinkedList<String>();
    queue.add(start);
    int curLevel = 1, nextLevel = 0;
    int len = 1;
    boolean found = false;
    for(String str : unvisited)
      adjMap.put(str, new LinkedList<String>());
    while(!queue.isEmpty()) {
      String word = queue.remove();
      unvisited.remove(word);
      List<String> neighbors = getNeighbors(word, unvisited);
      for(String neighbor : neighbors) {
        if(visited.add(neighbor)) {
          queue.add(neighbor);
          nextLevel++;
        }
        adjMap.get(neighbor).add(word);
        if(neighbor.equals(end))
          found = true;
      }
      if(--curLevel == 0) {
        if(found) break;
        curLevel = nextLevel;
        nextLevel = 0;
        len++;
      }
    }
    List<List<String>> result = new LinkedList<List<String>>();
    LinkedList<String> path = new LinkedList<String>();
    path.add(end);
    collectLadders(start, end, adjMap, len, path, result);
    return result;
  }

  List<String> getNeighbors(String word, Set<String> dict) {
    List<String> result = new LinkedList<String>();
    StringBuilder builder = new StringBuilder(word);
    for(int i=0; i<word.length(); i++) {
      for(char c='a'; c<='z'; c++) {
        char old = builder.charAt(i);
        builder.setCharAt(i, c);
        String replaced = builder.toString();
        if(dict.contains(replaced))
          result.add(replaced);
        builder.setCharAt(i, old);
      }
    }
    return result;
  }

  void collectLadders(String start, String cur, Map<String, Queue<String>> adjMap, int len, LinkedList<String> path, List<List<String>> result) {
    if(cur.equals(start)) {
      result.add(new ArrayList<String>(path));
      return;
    }
    if(path.size() <= len) {
      for (String str : adjMap.get(cur)) {
        path.addFirst(str);
        collectLadders(start, str, adjMap, len,  path, result);
        path.removeFirst();
      }
    }
  }

  public static void main(String args[]) {
    Set<String> dict = new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
    Object result = new WordLadderII().findLadders("hit", "cog", dict);
    System.out.println(result);
  }
}
