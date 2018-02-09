

public class RandomPlayer extends Player implements Constants{
    
    protected RandomGenerator random;
    
    public RandomPlayer(String n, char m, RandomGenerator rg){
        super(n,m);
        random= rg;
    }
    
    public void play(){
        
        while(!super.board.oWins() && !super.board.xWins() &&
              !super.board.isFull()) {
            
            makeMove();
            super.board.display();
            super.opponent.play();
        }
        
    }
    
    @Override
    public void makeMove(){
        boolean selection= true;
        int row=0, column=0;
        while(selection){
            row= random.discrete(0,2);
            column= random.discrete(0,2);
            if(super.board.getMark(row, column)==SPACE_CHAR){
                selection= false;
            }
        }
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
