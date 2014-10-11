import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = partition(s, 0);
        for(List<String> list : result)
            Collections.reverse(list);
        return result;
    }

    private List<List<String>> partition(String s, int begin) {
        List<List<String>> result = new LinkedList<List<String>>();
        if(begin >= s.length()) {
            result.add(new LinkedList<String>());
        }
        for(int i=begin; i<s.length(); i++) {
            int l = begin,r = i;
            for( ; l<r&&s.charAt(l)==s.charAt(r); l++,r--)
                ;
            if(l >= r) {
                List<List<String>> lists = partition(s, i + 1);
                for(List<String> list : lists) {
                    list.add(s.substring(begin, i + 1));
                }
                result.addAll(lists);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String s = "aab";
        Object result = new PalindromePartitioning().partition(s);
        System.out.println(result);
    }
}
