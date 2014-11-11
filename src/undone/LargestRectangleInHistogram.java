package undone;

import java.util.Stack;

public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] height) {
    Stack<Integer> s=new Stack<Integer>();
    int maxRec=0;
    for(int i=0;i<height.length;i++) {
      if(s.isEmpty()||height[s.peek()]<height[i])
        s.push(i);
      else if(height[s.peek()]>height[i]){
        while(!s.isEmpty()&&height[s.peek()]>height[i]) {
          int rec=(i-s.peek())*height[s.peek()];
          maxRec=rec>maxRec?rec:maxRec;
          s.pop();
        }
        if(!s.isEmpty()&&height[s.peek()]!=height[i]) {
          height[s.peek()+1]=height[i];
          s.push(s.peek()+1);
        }
        else {
          height[0]=height[i];
          s.push(0);
        }
      }
    }
    while(!s.isEmpty()) {
      int i=s.pop();
      int rec=height[i]*(height.length-i);
      maxRec=rec>maxRec?rec:maxRec;
    }
    return maxRec;
  }

  public static void main(String args[]) {
//    int[] height=new int[]{2,1,5,6,2,3};
    int[] height=new int[]{4,2,0,3,2,5};
    System.out.println(new LargestRectangleInHistogram().largestRectangleArea(height));
  }
}
