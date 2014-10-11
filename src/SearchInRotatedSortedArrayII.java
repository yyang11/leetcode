
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
    	int l = 0, r = A.length - 1;
    	while(l <= r) {
    		int m = (l + r) / 2;
    		if(A[m] == target) return true;
    		if(A[l] < A[m]) {
    			//left is sorted
    			if(A[l] <= target && target < A[m]) {
    				//?
    				r = m - 1;
    			}
    			else {
					l = m + 1;
				}
    		}
    		else if(A[l] > A[m]) {
    			//right is sorted
    			if(A[m] < target && target <= A[r]) {
    				l = m + 1;
    			}
    			else {
					r = m - 1;
				}
    		}
    		else {
    			l++;
    		}
    	}
    	return false;
    }//
    
    public static void main(String[] args) {
//		int[] A = {1, 1, 1, 1, 5, 1};
    	int[] A = {5, 1, 3};
		boolean result = new SearchInRotatedSortedArrayII().search(A, 3);
		System.out.println(result);
	}
}
