package undone;

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int A[], int B[]) {
    return doFind(A, 0, B, 0, (A.length + B.length + 1) / 2);
  }

  private double doFind(int A[], int m, int B[], int n, int kth) {
    if (n >= B.length) {
      if((A.length + B.length) % 2 == 0 && m + kth < A.length)
        return ((double)A[m + kth - 1] + A[m + kth]) / 2;
      return A[m + kth - 1];
    }
    if (m >= A.length) {
      if((A.length + B.length) % 2 == 0 && n + kth < B.length)
        return ((double)B[n + kth - 1] + B[n + kth]) / 2;
      return B[n + kth - 1];
    }

    if(kth <= 1) {
      int retVal;
      if(A[m] < B[n])
        retVal = A[m++];
      else
        retVal = B[n++];
      if((A.length + B.length) % 2 == 0) {
        int i = m >= A.length ? Integer.MAX_VALUE : A[m];
        int j = n >= B.length ? Integer.MAX_VALUE : B[n];
        return (Math.min(i, j) + (double)retVal) / 2;
      }
      return retVal;
    }

    int offset = Math.min(kth / 2, Math.min(A.length - m, B.length - n));
    if (A[m + offset - 1] >= B[n + offset - 1]) {
      return doFind(A, m, B, n + offset, kth - offset);
    } else {
      return doFind(A, m + offset, B, n, kth - offset);
    }
  }

  public static void main(String args[]) {
    int A[] = new int[]{1, 3, 5, 7, 9};
    int B[] = new int[]{2, 4, 6, 8};
    double result = new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B);
    System.out.println(result);
  }
}

/** more conscise
 class Solution {
 public:
 int getkth(int s[], int m, int l[], int n, int k){
 // let m <= n
 if (m > n)
 return getkth(l, n, s, m, k);
 if (m == 0)
 return l[k - 1];
 if (k == 1)
 return min(s[0], l[0]);

 int i = min(m, k / 2), j = min(n, k / 2);
 if (s[i - 1] > l[j - 1])
 return getkth(s, m, l + j, n - j, k - j);
 else
 return getkth(s + i, m - i, l, n, k - i);
 return 0;
 }

 double findMedianSortedArrays(int A[], int m, int B[], int n) {
 int l = (m + n + 1) >> 1;
 int r = (m + n + 2) >> 1;
 return (getkth(A, m ,B, n, l) + getkth(A, m, B, n, r)) / 2.0;
 }
 };
 */