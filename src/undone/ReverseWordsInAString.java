package undone;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strings = s.split("\\s");
        StringBuilder result = new StringBuilder();
        for(int i=strings.length-1; i>=0; i--) {
            result.append(strings[i]);
            if(i != 0 && !strings[i].equals(""))
                result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String args[]) {
//        String s = "the sky is blue";
        String s = " a  b ";
        String result = new ReverseWordsInAString().reverseWords(s);
        System.out.println(result);
    }
}
