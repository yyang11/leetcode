package undone;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  public List<String> fullJustify(String[] words, int L) {
    List<String> result = new ArrayList<String>();
    for(int i=0;i<words.length;) {
      StringBuilder line=new StringBuilder();
      int numChar=words[i].length(), j;
      line.append(words[i]);
      for(j=i+1;j<words.length&&numChar+words[j].length()+(j-i)<=L;numChar+=words[j++].length())
        ;
      boolean isLastLine=j>=words.length;
      int lineSpace=isLastLine?j-i-1:L-numChar;
      for(int k=i+1;k<j;k++) {
        int space=lineSpace%(j-k)==0?lineSpace/(j-k):lineSpace/(j-k)+1;
        lineSpace-=space;
        for(;space>0;space--) {
          line.append(" ");
        }
        line.append(words[k]);
      }
      while(line.length()<L)
        line.append(" ");
      i=j;
      result.add(line.toString());
    }
    return result;
  }

  public static void main(String args[]) {
//    String[] words=new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    String[] words=new String[]{""};
    List<String> result=new TextJustification().fullJustify(words, 16);
    System.out.println(result);
  }
}
