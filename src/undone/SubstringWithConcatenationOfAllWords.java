package undone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords{
  public List<Integer> findSubstring(String S, String[] L){
    List<Integer> res=new ArrayList<Integer>();
    if(S.length()==0||L.length==0)
      return res;
    Map<String,Boolean> words=new HashMap<String,Boolean>();
    int wordLen=L[0].length();
    for(int fp=0;fp<S.length();fp++){
      for(String word:L)
        words.put(word,false);
      int count=0;
      for(int sp=fp;sp<S.length();sp+=wordLen){
        if(words.containsKey(S.substring(sp,sp+wordLen)) && !words.get(S.substring(sp,sp+wordLen))){
          words.put(S.substring(sp, sp + wordLen),true);
          if (++count==L.length) {
            res.add(fp);
            break;
          }
        }
        else
          break;
      }
    }
    return res;
  }
  public static void main(String args[]){
    String S="barfoothefoobarman";
    String[] T=new String[]{"foo","bar"};
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(S,T));
  }
}
