public class KnightBoard{
  int[][] moves;
  int[][] board;
  int knightxcor;
  int knightycor;
  int counter;
  int jumps;
  int rows;
  int columns;

  public KnightBoard(int startingRows,int startingCols){
    int[][] b = new int[startingRows][startingCols];
    for(int i=0;i<b.length;i++){
      for(int l=0;l<b[0].length;l++){
        b[i][l]=0;
      }
    }
    board=b;
    moves=b;
    jumps=(startingCols*startingRows);
    rows=startingRows;
    columns=startingCols;
    counter=1;
  }

  public void clear(){
    int[][] b = new int[rows][columns];
    counter=1;
    board=b;

  }

  public String toString(){
    String str="";
    for(int i=0;i<board.length;i++){
      for(int l=0;l<board[0].length;l++){//for each piece
        if(board.length*board[0].length>=10){
          if(board[i][l]>=10){//if queen
            str+=board[i][l];
        }
          if(board[i][l]>0 && board[i][l]<10){
            str+=" ";
            str+=board[i][l];
        }
          if(board[i][l]==0){
            str+=" _";
          }
          if(l<board[0].length-1){
            str+=" ";
        }
          if(l>=board[0].length-1){
            str+="\n";
        }
      }
        else{
          if(board[i][l]==0){
            str+="_";
          }
          else{
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
    }
    return str;
  }


  public boolean place(int x, int y){
    if(x<0 || x>board[0].length-1 || y<0 || y>board.length-1){
      return false;
    }
    else{
      knightxcor=x;
      knightycor=y;
      board[y][x]=1;
      counter=1;
      return true;
  }
}

  public boolean isDone(){
    for(int i=0;i<board.length;i++){
      for(int l=0;l<board[0].length;l++){
        if(board[i][l]==0){
          return false;
        }
      }
    }
    return true;
  }

  public boolean move(int i) throws IndexOutOfBoundsException{
    if(i<1 || i>8){
      return false;
    }
    try{
      if(i==1 && board[knightycor-2][knightxcor+1]==0){
        board[knightycor-2][knightxcor+1]=counter+1;
        counter++;
        knightycor-=2;
        knightxcor+=1;
        return true;
    }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }
    try{
      if(i==4 && board[knightycor+2][knightxcor+1]==0){
        board[knightycor+2][knightxcor+1]=counter+1;
        counter++;
        knightycor+=2;
        knightxcor+=1;
        return true;
    }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==5 && board[knightycor+2][knightxcor-1]==0){
        board[knightycor+2][knightxcor-1]=counter+1;
        counter++;
        knightycor+=2;
        knightxcor-=1;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==8 && board[knightycor-2][knightxcor-1]==0){
        board[knightycor-2][knightxcor-1]=counter+1;
        counter++;
        knightycor-=2;
        knightxcor-=1;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==2 && board[knightycor-1][knightxcor+2]==0){
        board[knightycor-1][knightxcor+2]=counter+1;
        counter++;
        knightycor-=1;
        knightxcor+=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==3 && board[knightycor+1][knightxcor+2]==0){
        board[knightycor+1][knightxcor+2]=counter+1;
        counter++;
        knightycor+=1;
        knightxcor+=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==6 && board[knightycor+1][knightxcor-2]==0){
        board[knightycor+1][knightxcor-2]=counter+1;
        counter++;
        knightycor+=1;
        knightxcor-=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==7 && board[knightycor-1][knightxcor-2]==0){
        board[knightycor-1][knightxcor-2]=counter+1;
        counter++;
        knightycor-=1;
        knightxcor-=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }
    return false;
  }
  public boolean remove(int i) throws IndexOutOfBoundsException{
    if(i<1 || i>8){
      return false;
    }
    try{
      if(i==1){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor+=2;
        knightxcor-=1;
        return true;
    }
//follow tHIS
  }
    catch(IndexOutOfBoundsException e){
      return false;
    }
    try{
      if(i==4){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor-=2;
        knightxcor-=1;
        return true;
    }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==5){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor-=2;
        knightxcor+=1;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==8){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor+=2;
        knightxcor+=1;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==2){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor+=1;
        knightxcor-=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==3){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor-=1;
        knightxcor-=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==6){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor-=1;
        knightxcor+=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }

    try{
      if(i==7){
        board[knightycor][knightxcor]=0;
        counter--;
        knightycor+=1;
        knightxcor+=2;
        return true;
      }

  }
    catch(IndexOutOfBoundsException e){
      return false;
    }
    return false;
  }
  public boolean remove(int row,int col){
    if(col >= 0 && col < board[0].length&& row>=0 && row < board.length){
      if(board[row][col]!=0){
        board[row][col] = 0;
        counter--;
        return true;
      }
    }
    return false;
  }

  /*see format for toString below
  blank boards display 0's as underscores
  you get a blank board if you never called solve or
  when there is no solution
  @throws IllegalStateException when the board contains non-zero values.
  @throws IndexOutOfBoundsException when either parameter is negative
   or out of bounds.*/
  public boolean solve(int startingRow, int startingCol){
    return solveH(startingRow,startingCol,1);
  }

  public boolean solveH(int startingRow, int startingCol,int c){
    /*if(c==0){
      if(!place(startingCol,startingRow)){
        return false;
    }*/
    if(c>=jumps){
      return true;
    }
    if(board[startingRow][startingCol]!=0){
      return false;
    }

    for(int i=1;i<9;i++){
      //board[startingRow][startingCol]=counter;
      if(move(i)){
        if(solveH(knightycor, knightxcor,c+1)){
          return true;
          }
        remove(knightycor,knightxcor);
        }
      }
      /*clear();
      solveH(startingRow,startingCol,0,1);*/
      return false;
  }
  /*@throws IllegalStateException when the board contains non-zero values.
  @throws IndexOutOfBoundsException when either parameter is negative
 or out of bounds.
  public int countSolutions(int startingRow, int startingCol)
  Suggestion:*/
  //level is the # of the knight
}
