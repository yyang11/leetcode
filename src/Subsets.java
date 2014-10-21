package undone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] s) {
    Arrays.sort(s);
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    LinkedList<Integer> subset = new LinkedList<Integer>();
    collectSubsets(s, 0, subset, result);
    return result;
  }

  void collectSubsets(int[] s, int pos, LinkedList<Integer> subset, List<List<Integer>> result) {
    if(pos == s.length) {
      result.add(new ArrayList<Integer>(subset));
      return;
    }
    collectSubsets(s, pos + 1, subset, result);
    subset.addLast(s[pos]);
    collectSubsets(s, pos + 1, subset, result);
    subset.removeLast();
  }

  public static void main(String args[]) {
    int[] s = new int[]{4, 1, 0};
    Object result = new Subsets().subsets(s);
    System.out.println(result);
  }
}

  /*non-recursive solution c++:
  vector<vector<int> > subsets(vector<int> &S) {
    sort(S.begin(), S.end());
    vector<vector<int> > v(1);
    for(int i = 0; i < S.size(); ++i) {
      int j = v.size();
      while(j-- > 0) {
        v.push_back(v[j]);
        v.back().push_back(S[i]);
      }
    }
    return v;
  }
  */
