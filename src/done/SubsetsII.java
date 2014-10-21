import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    LinkedList<Integer> subset = new LinkedList<Integer>();
    collectSubsets(num, 0, subset, result);
    return result;
  }

  void collectSubsets(int[] s, int pos, LinkedList<Integer> subset, List<List<Integer>> result) {
    if(pos == s.length) {
      result.add(new ArrayList<Integer>(subset));
      return;
    }
    int numDup = 0;
    while(pos+numDup<s.length && s[pos+numDup]==s[pos])
      numDup++;
    collectSubsets(s, pos + numDup, subset, result);
    for(int i=0; i<numDup; i++) {
      subset.add(s[pos]);
      collectSubsets(s, pos + numDup, subset, result);
    }
    for(int i=0; i<numDup; i++)
      subset.removeLast();
  }
}