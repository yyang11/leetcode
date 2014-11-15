public class SudokuSolver {
  public void solveSudoku(char[][] board){
    solve(board);
  }
  public boolean solve(char[][] board){
    int i=-1,j=-1;
    for(int m=0;m<board.length&&i==-1;m++)
      for(int n=0;n<board[0].length&&i==-1;n++) {
        if(board[m][n]=='.') {
          i=m;
          j=n;
        }
      }
    if(i==-1)
      return true;
    boolean[] avail=new boolean[10];
    for(int k=0;k<avail.length;k++)
      avail[k]=true;
    for(int k=0;k<9;k++) {
      if(board[i][k]!='.')
        avail[board[i][k]-'0']=false;
      if(board[k][j]!='.')
        avail[board[k][j]-'0']=false;
      char ch=board[i/3*3+k/3][j/3*3+k%3];
      if(ch!='.')
        avail[ch-'0']=false;
    }

    for(int k=1;k<avail.length;k++) {
      if(avail[k]) {
        board[i][j]= (char)('0'+k);
        if(solve(board))
          return true;
      }
    }
    board[i][j]='.';
    return false;
  }
}
