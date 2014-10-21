import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * classic
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(num);
        for(int i=num.length-1; i>1; i--) {
            result.addAll(twoSum(num, i - 1, -num[i]));
            while(num[i - 1] == num[i] && i > 1)
                i--;
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] num, int len, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for(int i=0, j=len; i < j; i++) {
            while(num[j] > target - num[i] && i < j)
                j--;
            if(num[j] == target - num[i] && j != i) {
                result.add(new LinkedList<Integer>(Arrays.asList(num[i], num[j], -target)));
            }
            while(num[i + 1] == num[i] && i < j)
                i++;
        }
        return result;
    }

    public static void main(String args[]) {
        int[] num = new int[]{0, 0, 0, 0};
//        int[] num = new int[]{-1, 0, 1, 2, -1, -4};
        Object obj = new ThreeSum().threeSum(num);
        System.out.println(obj);
    }
}
