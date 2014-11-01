package done;

public class JumpGameII {
  public int jump(int[] A) {
    int pos=0;
    int step=0;
    while(pos<A.length) {
      if(pos==A.length-1)
        return step;
      if(pos+A[pos]>=A.length-1)  //case [2, 3, 1]
        return step+1;
      int nextPos=pos+1,nextNextJump=pos+1;
      for(int i=pos+1;i<A.length&&i<=pos+A[pos];i++){
        if(i+A[i]>=nextNextJump){
          nextPos=i;
          nextNextJump=nextPos+A[i];
        }
      }
      pos=nextPos;
      step++;
    }
    return step;
  }

  public static void main(String args[]) {
    int[] A=new int[]{2,3,1,1,4};
    System.out.println(new JumpGameII().jump(A));
  }
}
