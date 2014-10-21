public class EditDistance {
    public  int minDistance(String word1, String word2) {
        int row = 0;
        int col = 0;

        if (word1 != null)
            row = word1.length();
        if (word2 != null)
            col = word2.length();

        if (row == 0 || col == 0)
            return Math.max(row, col);

        int[][] matrix = new int[row+1][col+1];

        for (int i=0;i<=row;i++)
            matrix[i][0]=i;
        for (int i=0;i<=col;i++)
            matrix[0][i]=i;

        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    matrix[i][j]=matrix[i-1][j-1];//Remove and Add operation are not applicable.
                else 
                    matrix[i][j]=Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]),matrix[i-1][j-1])+1;
            }           
        }
        return matrix[row][col];
    } 
	
	public static void main(String[] args) {
		String word1 = "a";
		String word2 = "ab";
		int result = new EditDistance().minDistance(word1, word2);
		System.out.println(result);
	}
}
