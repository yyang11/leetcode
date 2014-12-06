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
}
