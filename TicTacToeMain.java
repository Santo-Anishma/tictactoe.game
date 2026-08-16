import java.util.Scanner;
class TicTacToe
{
    static char[][] board;
    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }
    private void initBoard(){
        for(char[] row : board){
            for(int j=0;j<row.length;j++){
                row[j]=' ';
            }
        }
    }
    static void displayBoard(){
        System.out.println("-------------");
        for(char[] row : board){
            System.out.print("|");
            for(char cell : row){
                System.out.print(cell + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

     static void placeMark(int row , int col, char mark) {
        if(row >= 0 && row <=2 && col >=0 && col <=2){
            board[row][col] = mark;
        }else{
            System.out.println("Invalid position");
        }
    }
     static boolean checkColWin(){

        for(int j=0;j<=2;j++){
            if(board[0][j] != ' ' && board [0][j] == board[1][j] && board[1][j] == board[2][j]){
                return true;
            }
        }
        return false;
    }

     static boolean checkRowWin(){
        for(int i=0;i<=2;i++){
            if(board [i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        return false;
    }

     static boolean checkDiagonalWin(){
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

}
class player{
    String name;
    char mark;
    static Scanner sc = new Scanner(System.in);
    
    player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    
    void makeMove(){
        int row, col;
        do { 
            System.out.println("Enter the row and col");
             row = sc.nextInt();
             col = sc.nextInt();
        } while (!isValidMove(row, col));

        TicTacToe.placeMark(row, col, mark);
    }   
    boolean isValidMove(int row, int col){
           if(row >=0 && row <=2 && col >=0 && col <=2){
              if(TicTacToe.board[row][col] == ' '){
                  return true;
              }  
           }
        return false;
    }
}

public class TicTacToeMain {
         public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        TicTacToe.displayBoard();
        
        player p1 = new player("Tom", 'X');
        player p2 = new player("Jerry", 'O');
        player cp;
        cp = p1;
    while(true){
        System.out.println(cp.name + " turn");
        cp.makeMove();
        TicTacToe.displayBoard();
        if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagonalWin()){
            System.out.println(cp.name + " has won");
            break;
        }
        else{
            if(cp == p1){
                cp = p2;
            } else{
                cp = p1;
            }
         }
        }
    }
 }
