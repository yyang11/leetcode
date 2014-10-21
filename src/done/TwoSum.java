

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
    	int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
    	Arrays.sort(numbers);
    	for(int i=0, j=numbers.length - 1; i < j && i < numbers.length; i++) {
    		while(numbers[j] > target-numbers[i] && j > i)
    			j--;
    		if(numbers[j]==target-numbers[i]) {
    			int[] res = new int[2];
    			int m, n;
    			for(m=0; numbersCopy[m]!=numbers[i]; m++);
    			for(n=numbersCopy.length - 1; numbersCopy[n]!=numbers[j]; n--);
    			res[0] = Math.min(m + 1, n + 1);
    			res[1] = Math.max(m + 1, n + 1);
    			return res;
    		}
    	}
        return null;
    }
    
    public static void main(String args[]) {
    	int[] arr = {0, 7, 11, 0};
    	int[] res = new TwoSum().twoSum(arr, 0);
    	System.out.print(res[0] + " " + res[1]);
    }
}
