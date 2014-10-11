

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length==0 || matrix[0].length==0)
    		return 0;
    	Rec[][] recs = new Rec[matrix.length][matrix[0].length];
    	for(int i=0; i<recs.length; i++)
    		recs[i][0] = matrix[i][0]=='0'?new Rec(0, 0):new Rec(1, 1);
       	for(int i=0; i<recs[0].length; i++)
       		recs[0][i] = matrix[0][i]=='0'?new Rec(0, 0):new Rec(1, 1);
       	for(int i=1; i<matrix.length; i++) {
       		for(int j=1; j<matrix[0].length; j++) {
       			Rec left = new Rec(recs[i][j-1].x, recs[i][j-1].y);
       			for(int k=0; k<left.y; k++) {
       				if(matrix[i-k][j]=='0') {
       					left = new Rec(0, 0);
       					break;
       				}
       			}
       			if(left.getArea()!=0)
       				left.x++;
       			Rec top = new Rec(recs[i-1][j].x, recs[i-1][j].y);
       			for(int k=0; k<top.x; k++) {
       				if(matrix[i][j-k]=='0') {
       					top=new Rec(0, 0);
       					break;
       				}
       			}
       			if(top.getArea()!=0)
       				top.y++;
       			Rec newRec = left.getArea()>top.getArea()?left:top;
       			if(newRec.getArea()!=0) {
       				recs[i][j] = newRec;
       			}
       			else {
					recs[i][j] = matrix[i][j]=='0'?new Rec(0, 0):new Rec(1, 1);
				}
       		}
       	}
       	Rec maxRec = new Rec(0, 0);
       	for(int i=1; i<matrix.length; i++) {
       		for(int j=1; j<matrix[0].length; j++) {
       			maxRec = recs[i][j].getArea()>maxRec.getArea()?recs[i][j]:maxRec;
       		}
       	}
       	return maxRec.getArea();
    }
    
    private class Rec {
    	int x;
    	int y;
    	public Rec(int x, int y) {
    		this.x=x;
    		this.y=y;
    	}
    	public int getArea() {
    		return x*y;
    	}
    }
    
    public static void main(String args[]) {
    	char[][] input = {{'1', '1'},{'1', '1'}};
    	int maxRec = new MaximalRectangle().maximalRectangle(input);
    	System.out.println(maxRec);
    }
}
