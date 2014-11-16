import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords{
  public List<Integer> findSubstring(String S, String[] L){
    List<Integer> res=new ArrayList<Integer>();
    if(S.length()==0||L.length==0)
      return res;

    Map<String,Integer> dest=new HashMap<String, Integer>();
    Map<String,Integer> words=new HashMap<String, Integer>();
    for(String l:L){
      if(!dest.containsKey(l))
        dest.put(l,0);
      dest.put(l,dest.get(l)+1);
    }

    int wordLen=L[0].length();
    for(int i=0;i<wordLen;i++){
      int count=0;
      words.clear();
      for(int fp=i;fp<=S.length()-L.length*wordLen;){
        for(int sp=fp;sp<=S.length()-wordLen;sp+=wordLen){
          String sub=S.substring(sp,sp+wordLen);
          if(dest.containsKey(sub)&&(!words.containsKey(sub)||words.get(sub)<dest.get(sub))){
            if(!words.containsKey(sub))
              words.put(sub,0);
            words.put(sub,words.get(sub)+1);
            if (++count==L.length) {
              res.add(fp);
              String rm=S.substring(fp,fp+wordLen);
              fp+=wordLen;
              count--;
              words.put(rm,words.get(rm)-1);
            }
          }
          else {
            fp+=wordLen;
            count=0;
            words.clear();
            break;
          }
        }
      }
    }
    return res;
  }

  public static void main(String args[]){
    String S="abababab";
    String[] T=new String[]{"a","b","a"};
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(S,T));
  }
}
