public class SingleNumber {
    //r u kidding me?
    public int singleNumber(int[] A) {
        int x = 0;
        for(int i=0; i<A.length; i++)
            x ^= A[i];
        return x;
    }
}
