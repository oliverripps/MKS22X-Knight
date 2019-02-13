public class KnightBoard{
  int[][] moves;
  int[][] board;
  public KnightBoard(int startingRows,int startingCols){
    int[][] b = new int[startingRows][startingCols];
    board=b;
    moves=b;
  }
  //Initialize the board to the correct size and make them all 0's
  public String toString() throws IllegalStateException(){
    String str="";
    for(int i=0;i<board.length;i++){
      for(int l=0;l<board[0].length;l++){//for each piece
        if(board[i][l]>=10){//if queen
          str+=board[i][l];
        }
        if(board[i][l]>0 && board[i][l]<10)
          str+=" ";
          str+=board[i][l];
        }
        if(l<board[0].length-1){
          str+=" ";
        }
        if(l>=board[0].length-1){
          str+="\n";
        }

      }
    }
    return str;
  }
  }

  /*see format for toString below
  blank boards display 0's as underscores
  you get a blank board if you never called solve or
  when there is no solution
  @throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
   or out of bounds.*/
  public boolean solve(int startingRow, int startingCol)
  /*@throws IllegalStateException when the board contains non-zero values.
  @throws IllegalArgumentException when either parameter is negative
 or out of bounds.
  public int countSolutions(int startingRow, int startingCol)
  Suggestion:*/
  private boolean solveH(int row ,int col, int level)
  //level is the # of the knight









}
