

//damn it
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		if(n==0)
			return;
		if(m==0) {
			System.arraycopy(B, 0, A, 0, n);
			return;
		}
		int i=0, j=0;
        for(int pos=m; pos<2*m+n; pos++) {
        	if(i==m) {
        		for( ; j<n; j++) {
					A[pos % (m + n)] = B[j];
					pos++;
        		}
        	}
        	else if(j==n) {
        		//do nothing
        		break;
			}
        	else {
				if (A[i] < B[j]) {
					A[pos % (m + n)] = A[i++];
				} else {
					A[pos % (m + n)] = B[j++];
				}
        	}
        }
        
        swap(A, 0, m, n);
    }
	
	private void swap(int arr[], int startPos, int m, int n) {
		if(m < n) {
			for(int i=0; i<m; i++) {
				int temp = arr[startPos + i];
				arr[startPos + i] = arr[startPos + n + i];
				arr[startPos + n + i] = temp;
			}
			swap(arr, startPos, m, n - m);
		}
		else if(n < m) {
			for(int i=0; i<n; i++) {
				int temp = arr[startPos + i];
				arr[startPos + i] = arr[startPos + m + i];
				arr[startPos + m + i] = temp;
			}
			swap(arr, startPos + n, m - n, n);
		}
		else {
			for(int i=0; i<m; i++) {
				int temp = arr[startPos + i];
				arr[startPos + i] = arr[startPos + m + i];
				arr[startPos + m + i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1, 3, 5, 7, 0, 0, 0};
		int[] B = {2, 4, 6};
		MergeSortedArray solution = new MergeSortedArray();
		solution.merge(A, A.length - B.length, B, B.length);
		for(int i=0; i<A.length; i++)
			System.out.print(A[i] + " ");
	}
}