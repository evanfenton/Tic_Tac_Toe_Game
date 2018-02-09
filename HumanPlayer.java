import java.util.Scanner;

public class HumanPlayer extends Player{
    
    protected HumanPlayer(String n, char m){
        super(n,m);
    }
    
    @Override
    protected void play(){
        
        while(!super.board.oWins() && !super.board.xWins() &&
              !super.board.isFull()) {
            
            makeMove();
            super.board.display();
            super.opponent.play();
        }
        
    }
    
    @Override
    protected void makeMove(){
        
        Scanner scan= new Scanner(System.in);
        int row,column;
        
        System.out.println(super.name+ ", what row should your next "+ super.mark+
                           " be placed in?");
        row=Integer.parseInt(scan.nextLine());
        
        System.out.println(super.name+ ", what column should your next "+super.mark+
                           " be placed in?");
        column=Integer.parseInt(scan.nextLine());
        
        super.board.addMark(row,column,super.mark);
        System.out.println();
        
    }
    
    public String getName() {
        return super.getName();
    }
    
    public void setOpponent(Player opponent) {
        super.setOpponent(opponent);
    }
    
    public void setBoard(Board board) {
        super.setBoard(board);
    }
    
    
    
}

