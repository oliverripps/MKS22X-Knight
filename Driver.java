public class Driver{

  public static void main(String[] args){
    KnightBoard test = new KnightBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    test.solve(2,2);
    System.out.println(test.toString());
    //System.out.println(test.countSolutions(0,0));
    //System.out.println(test.toStringMoves());
  }








}
