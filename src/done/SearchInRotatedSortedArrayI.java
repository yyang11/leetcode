public class SearchInRotatedSortedArrayI {
	int rotatePivot, length;
	
    public int search(int[] A, int target) {
    	length = A.length;
    	rotatePivot = searchRotatePivot(A, 0, A.length);
    	return doSearch(A, 0, A.length, target);
    }
    
    int doSearch(int[] A, int m, int n, int target) {
    	if(m > n)
    		return -1;
    	int mid = (m + n) / 2;
    	if(A[trans(mid)] == target)
    		return trans(mid);
    	if(A[trans(mid)] > target)
    		return doSearch(A, m, mid - 1, target);
    	return doSearch(A, mid + 1, n, target);
    }
    
    int searchRotatePivot(int[] A, int m, int n) {
    	if(m == n)
    		return m;
    	int mid = (m + n) / 2;
    	if(A[mid] > A[m]) {
    		return searchRotatePivot(A, mid, n);
    	}
    	else {
			return searchRotatePivot(A, m, mid);
		}
    }

    int trans(int idx) {
    	return (idx + rotatePivot + 1) % length;
    }
    
    public static void main(String[] args) {
//    	int[] A = {4, 5, 6, 7, 0, 1, 2};
    	int[] A = {4, 5, 1, 2, 3};
		int result = new SearchInRotatedSortedArrayI().search(A,  1);
		System.out.println(result);
	}
}
