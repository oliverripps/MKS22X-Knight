import java.util.ArrayList;

public class KnightBoard{
  int[][] moves;
  int[][] board;
  int knightxcor;
  int knightycor;
  int counter;
  int jumps;
  int rows;
  int columns;


//add in all restrictions from website
//add comments

  public KnightBoard(int startingRows,int startingCols){
    int[][] b = new int[startingRows][startingCols];
    for(int i=0;i<b.length;i++){
      for(int l=0;l<b[0].length;l++){
        b[i][l]=0;
      }
    }
    setupmovesboard(startingRows,startingCols);
    board=b;
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
  private void setupmovesboard(int r,int c){
    int[][] m = new int[r][c];
    moves=m;
    for(int i=0;i<moves.length;i++){
      for(int l =0;l<moves[0].length;l++){
        moves[i][l]=0;
      }
    }
    for(int i=0;i<moves.length;i++){
      for(int l=0;l<moves[0].length;l++){
        //System.out.println("hi");
        setupmoves(i,l);
      }
    }
  }

  public int getmoves(int r, int c){
    return moves[r][c];
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

  public String toStringMoves(){
    String str="";
    for(int i=0;i<moves.length;i++){
      for(int l=0;l<moves[0].length;l++){//for each piece
        if(moves.length*moves[0].length>=10){
          if(moves[i][l]>=10){//if queen
            str+=moves[i][l];
        }
          if(moves[i][l]>0 && moves[i][l]<10){
            str+=" ";
            str+=moves[i][l];
        }
          if(moves[i][l]==0){
            str+=" _";
          }
          if(l<moves[0].length-1){
            str+=" ";
        }
          if(l>=moves[0].length-1){
            str+="\n";
        }
      }
        else{
          if(moves[i][l]==0){
            str+="_";
          }
          else{
            str+=moves[i][l];
          }
          if(l<moves[0].length-1){
            str+=" ";
        }
          if(l>=moves[0].length-1){
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

  /*public static void Sort(ArrayList<Integer> ary){
    if(ary.size()!=0){//testing for not being 0
      int current;
      for(int i = 1;i<ary.size();i++){//starting with the first wrong one, loop through
        current=ary.get(i).getValue();//current is the one you want to sort
        int l = i-1;//the first one sorted
        while(l>=0 && current<=ary.get(l).getValue()){//while it is still bigger
          ary.set(l+1,ary.get(l).getValue());//shift over
          l--;
        }
        ary.set(l+1,current);//place
      }
    }
  }*/
public static void Sort(ArrayList<Moves> data){
  if(data.size()!=0){
  boolean ready= false;//boolean to see if a change was made this round
  Moves current;
  while(!ready){
    ready=true;
    for(int i = 0;i<data.size()-1;i++){//looping through each element
      if(data.get(i).getValue()>data.get(i+1).getValue()){//if they are in the wrong order, switch them
        current=data.get(i);
        data.set(i,data.get(i+1));
        data.set(i+1,current);
        ready=false;//showing a change was made
      }
    }
  }
}
}

  public ArrayList<Moves> orderMoves(int r,int c){
    ArrayList<Moves> a = new ArrayList<Moves>(0);
    int failures=0;
    try{
      if((r-2)>=0 && (r-2)<moves.length && (c+1)>=0 && (c+1)<moves[0].length){
        int o=moves[r-2][c+1];
        Moves option1= new Moves(o,"option1");
        a.add(option1);
    }
      if(r-2>=0 && r-2<moves.length && c-1>=0 && c-1<moves[0].length){
        int o=moves[r-2][c-1];
        Moves option8= new Moves(o,"option8");
        a.add(option8);
      }
      if(r+2>=0 && r+2<moves.length && c+1>=0 && c+1<moves[0].length){
        int o=moves[r+2][c+1];
        Moves option4= new Moves(o,"option4");
        a.add(option4);
      }
      //continue with this
      if(r+2>=0 && r+2<moves.length && c-1>=0 && c-1<moves[0].length){
        int o=moves[r+2][c-1];
        Moves option5= new Moves(o,"option5");
        a.add(option5);
    }
      if(r+1>=0 && r+1<moves.length && c+2>=0 && c+2<moves[0].length){
        int o=moves[r+1][c+2];
        Moves option3= new Moves(o,"option3");
        a.add(option3);
}
      if(r+1>=0 && r+1<moves.length && c-2>=0 && c-2<moves[0].length){
        int o=moves[r+1][c-2];
        Moves option6= new Moves(o,"option6");
        a.add(option6);
}
      if(r-1>=0 && r-1<moves.length && c+2>=0 && c+2<moves[0].length){
        int o=moves[r-1][c+2];
        Moves option2=new Moves(o,"option2");
        a.add(option2);
}
      if(r-1>=0 && r-1<moves.length && c-2>=0 && c-2<moves[0].length){
        int o=moves[r-1][c-2];
        Moves option7= new Moves(o,"option7");
        a.add(option7);
}
  }
    catch(IndexOutOfBoundsException e){
      failures++;
    }
  Sort(a);
  return a;
}

  private void setupmoves(int r, int c){
    int failures=0;
    try{
      if((r-2)>=0 && (r-2)<moves.length && (c+1)>=0 && (c+1)<moves[0].length){
        moves[r-2][c+1]+=1;
    }
      if(r-2>=0 && r-2<moves.length && c-1>=0 && c-1<moves[0].length){
        moves[r-2][c-1]+=1;
      }
      if(r+2>=0 && r+2<moves.length && c+1>=0 && c+1<moves[0].length){
        moves[r+2][c+1]+=1;
      }
      if(r+2>=0 && r+2<moves.length && c-1>=0 && c-1<moves[0].length){
        moves[r+2][c-1]+=1;
    }
      if(r+1>=0 && r+1<moves.length && c+2>=0 && c+2<moves[0].length){
        moves[r+1][c+2]+=1;
}
      if(r+1>=0 && r+1<moves.length && c-2>=0 && c-2<moves[0].length){
        moves[r+1][c-2]+=1;
}
      if(r-1>=0 && r-1<moves.length && c+2>=0 && c+2<moves[0].length){
        moves[r-1][c+2]+=1;
}
      if(r-1>=0 && r-1<moves.length && c-2>=0 && c-2<moves[0].length){
        moves[r-1][c-2]+=1;
}
  }
    catch(IndexOutOfBoundsException e){
      failures++;
    }

  }
  public boolean move(String p) throws IndexOutOfBoundsException{
    String f = p.substring(p.length()-1);
    int i= Integer.parseInt(f);
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
        counter++;https://www.mkyong.com/java/java-convert-string-to-int/
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
  public boolean remove(String p) throws IndexOutOfBoundsException{
    String f = p.substring(p.length()-1);
    int i= Integer.parseInt(f);
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
    //System.out.println(test.toString());
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
    return solveH(startingRow,startingCol,0);
  }

  public boolean solveH(int startingRow, int startingCol,int c){
    knightxcor=startingCol;
    knightycor=startingRow;
    if(c==0){
      board[knightycor][knightxcor]=counter;
    }
    if(c>=jumps-1){
      return true;
    }
    /*if(board[startingRow][startingCol]!=0){
      return false;
    }*/
    ArrayList<Moves> b = new ArrayList<Moves>(0);
    b=orderMoves(knightycor,knightxcor);
    for(int i=0;i<b.size();i++){
      //board[startingRow][startingCol]=counter;
      if(move(b.get(i).getName())){
        //System.out.println(c);
        if(solveH(knightycor, knightxcor,c+1)){
          //System.out.println(c);
          return true;
          }
        remove(b.get(i).getName());
        }
      }
      /*clear();
      solveH(startingRow,startingCol,0,1);*/
      return false;
  }

  public String toStringSort(ArrayList<Moves> b){
    String str="(";
    for(int i=0;i<b.size();i++){
      str+=b.get(i).getValue();
      str+=",";
    }
    return str;
  }
  /*@throws IllegalStateException when the board contains non-zero values.
  @throws IndexOutOfBoundsException when either parameter is negative
 or out of bounds.*/
  public int countSolutions(int startingRow, int startingCol){
    return countH(startingRow,startingCol,0);
  }

  public int countH(int startingRow, int startingCol, int c){
    knightxcor=startingCol;
    knightycor=startingRow;
    int solutions=0;
    if(c>=jumps-1){
      return 1;
    }
    if(c==0){
      board[knightycor][knightxcor]=counter;
    }
    ArrayList<Moves> b = new ArrayList<Moves>(0);
    b=orderMoves(knightycor,knightxcor);
    //System.out.println(toStringSort(b));
    for(int i=0;i<b.size();i++){
      if(move(b.get(i).getName())){
        solutions+=countH(knightycor, knightxcor,c+1);
          //System.out.println(c);
        remove(b.get(i).getName());
        }
      }
      return solutions;
  }

  public static void main(String[] args){

  for(int i=0;i<5;i++){
  KnightBoard b;
  int[]m =   {4,5,5,5,5};
  int[]n =   {4,5,4,5,5};
  int[]startx = {0,0,0,1,2};
  int[]starty = {0,0,0,1,2};
  int[]answers = {0,304,32,56,64};
  if(i >= 0 ){
    try{
      int correct = answers[i];
      b = new KnightBoard(m[i%m.length],n[i%m.length]);

      int ans  = b.countSolutions(startx[i],starty[i]);

      if(correct==ans){
        System.out.println("PASS board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans);
      }else{
        System.out.println("FAIL board size: "+m[i%m.length]+"x"+n[i%m.length]+" "+ans+" vs "+correct);
      }
    }catch(Exception e){
      System.out.println("FAIL Exception case: "+i);

    }
  }


}







  }

  }
