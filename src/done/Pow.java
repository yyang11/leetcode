public class Pow {
    public double pow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;

        double extra=pow(x,n%2);
        double half=pow(x,n/2);
        return half*half*extra;
    }
    
    /*
    public double pow(double x, int n) {
        //non-recursive
        //awesome!
        if(n<0) return 1/(x*pow(x,-(n+1)));
        if(n==0) return 1;
        double left=x,right=1;
        while(n!=1) {
            if(n%2==1) right*=left;
            left*=left;
            n/=2;
        }
        return left*right;
    }
    */
}
