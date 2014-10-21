import java.util.LinkedList;
import java.util.List;

/**
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        return permute(num, 0);
    }

    private List<List<Integer>> permute(int[] num, int pos) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(pos == num.length) {
            List<Integer> list = new LinkedList<Integer>();
            for(int i : num)
                list.add(i);
            result.add(list);
            return result;
        }
        for(int i=pos; i<num.length; i++) {
            boolean isUnique = true;
            for(int j=pos; j<i; j++) {
                if(num[j] == num[i])
                    isUnique = false;
            }
            if(isUnique) {
                swap(num, pos, i);
                result.addAll(permute(num, pos + 1));
                swap(num, pos, i);
            }
        }
        return result;
    }

    private void swap(int[] num, int m, int n) {
        int tmp = num[m];
        num[m] = num[n];
        num[n] = tmp;
    }

    public static void main(String args[]) {
        int[] num = new int[]{1, 1, 2};
        Object result = new PermutationsII().permuteUnique(num);
        System.out.println(result);
    }
}
