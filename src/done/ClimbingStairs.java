
public class ClimbingStairs {
    public int climbStairs(int n) {
		int[] ways = new int[n+2];
		ways[0] = 0;
		ways[1] = 1;
		for(int i=0; i<n; i++) {
			ways[i+2] = ways[i] + ways[i+1];
		}
		return ways[n+1];
	}
	
	public static void main(String[] args) {
		int result = new ClimbingStairs().climbStairs(3);
		System.out.println(result);
	}
}
