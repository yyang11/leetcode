package done;

/**
 * hard $_$
 * 也可以分别从左和从右遍历，将结果写入数组中，然后依次取两数组的最大值
 */
public class Candy {
  public int candy(int[] r) {
    int sumCan = 1;
    int seqLen = 0;
    int maxCanInSeq = 1;
    int maxCanInSeqCpy = maxCanInSeq;
    for(int i=1; i<r.length; i++) {
      if(r[i - 1] > r[i]) {
        seqLen++;
        if(seqLen == maxCanInSeqCpy) {
          seqLen++;
        }
        sumCan += seqLen;
        maxCanInSeq = 1;
      }
      else {
        if(r[i - 1] == r[i]) {
          maxCanInSeq = 1;
        }
        else {
          maxCanInSeq++;
        }
        seqLen = 0;
        sumCan += maxCanInSeq;
        maxCanInSeqCpy = maxCanInSeq;
      }
    }
    return sumCan;
  }

  public static void main(String args[]) {
    int[] ratings = new int[]{2, 1, 2};
    int result = new Candy().candy(ratings);
    System.out.println(result);
  }
}
