package undone;

import java.util.Stack;

public class TrappingRainWater {
//answer by dragonmigo
//  int trap(int A[], int n) {
//    if(n==0) return 0;
//    int l = 0, r = n-1,block = 0,all = 0,curlevel = 0;
//    while(l<=r)
//    {
//      if(Math.min(A[l],A[r])>curlevel)
//      {
//        all += (Math.min(A[l],A[r])-curlevel)*(r-l+1);
//        curlevel = Math.min(A[l],A[r]);
//      }
//      if(A[l]<A[r])
//        block += A[l++];
//      else
//        block += A[r--];
//    }
//    return all-block;
//  }

  public int trap(int[] A) {
    //先增后减
    if(A.length==0)
      return 0;
    int water=0;
    int maxi=0;
    for(int i=0;i<A.length;i++) {
      maxi=A[i]>=A[maxi]?i:maxi;
    }
    Stack<Integer> stack=new Stack<Integer>();
    stack.push(0);
    for(int i=0;i<=maxi;i++) {
      water-=A[i];
      if(A[i]>=A[stack.peek()]) {
        water+=A[stack.peek()]*(i-stack.peek());
        stack.push(i);
      }
    }
    stack.clear();
    stack.push(A.length-1);
    for(int i=A.length-1;i>=maxi;i--) {
      water-=A[i];
      if(A[i]>=A[stack.peek()]) {
        water+=A[stack.peek()]*(stack.peek()-i);
        stack.push(i);
      }
    }
    water+=A[maxi]*2;
    return water;
  }
}
