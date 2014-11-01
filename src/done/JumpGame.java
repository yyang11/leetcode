package done;

public class JumpGame {
  public boolean canJump(int[] A) {
    int pos=0;
    while(pos<A.length) {
      if(pos==A.length-1)
        return true;
      if(A[pos]==0)
        return false;
      int nextPos=pos+1,nextNextJump=pos+1;
      for(int i=pos+1;i<A.length&&i<=pos+A[pos];i++){
        if(i+A[i]>nextNextJump){
          nextPos=i;
          nextNextJump=nextPos+A[i];
        }
      }
      pos=nextPos;
    }
    return true;
  }

  public static void main(String args[]) {
//    int[] A=new int[]{3,2,1,0,4};
    int[] A=new int[]{2,3,1,1,4};
    System.out.println(new JumpGame().canJump(A));
  }
}
